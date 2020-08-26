package com.kandy.pjp2.week2assignment3;

public class CurrencyConversion {
	public static float convertCurrency(String currency, float amount) {
		if(currency.equals("INR"))
			return amount/66;
		else if(currency.equals("GBP"))
			return (float) (amount/0.67);
		else if(currency.equals("SGP"))
			return (float) (amount/1.5);
		else if(currency.equals("HKD"))
			return amount/8;
		else
			return amount;
	}
}
