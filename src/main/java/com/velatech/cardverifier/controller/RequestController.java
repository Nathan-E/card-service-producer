package com.velatech.cardverifier.controller;

import com.velatech.cardverifier.dto.clientResponse.ClientResponse;
import com.velatech.cardverifier.dto.statPackage.StatResponse;
import com.velatech.cardverifier.exception.RecordNotFoundException;
import com.velatech.cardverifier.service.CardService;
import com.velatech.cardverifier.service.KafkaProducerConfig;
import com.velatech.cardverifier.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/card-scheme")
@RestController
@CrossOrigin
public class RequestController {

    @Autowired
    private CardService verifyCard;

    @Autowired
    private QueryService queryService;
    
    @Autowired
    private KafkaProducerConfig kafkaProducer;


    @GetMapping("/verify/{cardNumber}")
    public ClientResponse getCardDetails(@PathVariable("cardNumber") String cardNumber) {
    	
    	ClientResponse response = verifyCard.verifyCard(cardNumber);
    	
    	if(response != null)
    		kafkaProducer.sendMessage(response);
    	return response;
    }


    @GetMapping(value = "/stats", params = {"start", "limit"})
    public ResponseEntity<StatResponse> getStats(@RequestParam("start") int start, @RequestParam("limit") int limit) {
        if(start >= 1) start--;

        try{
            StatResponse statResponse = queryService.getStatStructure(PageRequest.of(start, limit));
            return new ResponseEntity<>(statResponse, HttpStatus.OK);

        }
        catch(Exception e){
            throw new RecordNotFoundException("No records found within the specified range");

        }
    }
}
