package com.velatech.cardverifier.dto.statPackage;

import java.util.HashMap;
import java.util.Map;

public class StatResponse {

    private boolean success;
    private int start;
    private int limit;
    private Long size;
    private Map<String, Object> payload= new HashMap<>();
    
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Map<String, Object> getPayload() {
		return payload;
	}
	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}


}
