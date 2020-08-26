package com.kandy.pjp2.week2assignment3;


public class Summary {
	
	private String countryOrCity;
	private String gender;
	private float aversgeIncome;
	private int entries;
	
	public Summary() {}
	
	public Summary(String countryOrCity, String gender, float aversgeIncome, int entries) {
		super();
		this.countryOrCity = countryOrCity;
		this.gender = gender;
		this.aversgeIncome = aversgeIncome;
		this.entries = entries;
	}

	public int getEntries() {
		return entries;
	}
	public void setEntries(int entries) {
		this.entries = entries;
	}
	public String getCountryOrCity() {
		return countryOrCity;
	}
	public void setCountryOrCity(String countryOrCity) {
		this.countryOrCity = countryOrCity;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getAversgeIncome() {
		return aversgeIncome;
	}
	public void setAversgeIncome(float aversgeIncome) {
		this.aversgeIncome = aversgeIncome;
	}
}
