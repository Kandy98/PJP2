package com.kandy.pjp2.week2assignment3;

import java.util.List;

public class IncomeReport {
	private String city;
	private String country;
	private String gneder;
	private String currency;
	private float amount;
	
	public IncomeReport() {}
	
	public IncomeReport(List<String> incomeEntry) {
		super();
		this.city = incomeEntry.get(0);
		this.country = incomeEntry.get(1);
		this.gneder = incomeEntry.get(2);
		this.currency = incomeEntry.get(3);
		this.amount = Float.parseFloat(incomeEntry.get(4));
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGneder() {
		return gneder;
	}
	public void setGneder(String gneder) {
		this.gneder = gneder;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
}
