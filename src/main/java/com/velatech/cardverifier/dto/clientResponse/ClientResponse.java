package com.velatech.cardverifier.dto.clientResponse;


public class ClientResponse {

    private boolean success;
    private ClientPayload payload;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ClientPayload getPayload() {
		return payload;
	}
	public void setPayload(ClientPayload payload) {
		this.payload = payload;
	}
    
    
}
