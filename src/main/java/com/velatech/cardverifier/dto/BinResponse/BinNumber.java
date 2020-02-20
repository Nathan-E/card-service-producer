package com.velatech.cardverifier.dto.BinResponse;


public class BinNumber {

    private int length;
    private boolean luhn;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isLuhn() {
		return luhn;
	}
	public void setLuhn(boolean luhn) {
		this.luhn = luhn;
	}
}
