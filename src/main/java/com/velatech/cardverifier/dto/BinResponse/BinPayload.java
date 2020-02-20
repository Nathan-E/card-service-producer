package com.velatech.cardverifier.dto.BinResponse;


public class BinPayload {

    private BinNumber number;
    private String scheme;
    private String type;
    private Country country;
    private Bank bank;
    
	public BinNumber getNumber() {
		return number;
	}
	public void setNumber(BinNumber number) {
		this.number = number;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
    
    
}
