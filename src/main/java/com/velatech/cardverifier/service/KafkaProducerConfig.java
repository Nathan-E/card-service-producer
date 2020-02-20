package com.velatech.cardverifier.service;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velatech.cardverifier.dto.clientResponse.ClientResponse;

@Service
public class KafkaProducerConfig {

	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
	private static final String TOPIC = "com.ng.vela.even.card_verified";


	public void sendMessage(Object response) {
		
		Properties props = new Properties();
		 props.put("bootstrap.servers", "localhost:9092");
		 props.put("acks", "all");
		 props.put("key.serializer", "org.springframework.kafka.support.serializer.JsonSerializer");
		 props.put("value.serializer", "org.springframework.kafka.support.serializer.JsonSerializer");

		 Producer<String, Object> producer = new KafkaProducer<String, Object>(props);
		 
		 try {
			 producer.send(new ProducerRecord<String, Object>(TOPIC, Integer.toString(1), response));
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 producer.close();
		 }
		
		logger.info(String.format("#### -> Producing message -> %s", response));
	}
}
