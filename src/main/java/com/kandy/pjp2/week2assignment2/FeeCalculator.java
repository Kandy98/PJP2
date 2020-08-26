package com.kandy.pjp2.week2assignment2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeeCalculator {
	
	Map<String, Transaction> buy = new HashMap<>();
	Map<String, Transaction> sell = new HashMap<>();
	
	public void normalTransaction(Transaction transaction) {
		if (transaction.getPriorityFlag().equals("Y")) {
			transaction.setProcessingFee(500);

		} 
		else {
			if (transaction.getTransactionType().equals("SELL") || 
					transaction.getTransactionType().equals("WITHDRAW")) {
				transaction.setProcessingFee(100);
			}
			else {
				transaction.setProcessingFee(50);
			}
		}
	}
	
	public void intradayTransaction() {
		
		buy.forEach((key, value) -> {
			if(sell.containsKey(key)) {
				int buySecurityTrans = value.getProcessingFee();
				value.setProcessingFee(buySecurityTrans + 10);
				
				int sellSecurityTrans = sell.get(key).getProcessingFee();
				sell.get(key).setProcessingFee(sellSecurityTrans + 10);
			}
		});
	}
	
	public void calculateFee(List<Transaction> transaction) {	
		
		for(Transaction t: transaction) {
			normalTransaction(t);
			
			String key = t.getClientId() + t.getSecurityId() + t.getTransactionDate();
			if(t.getTransactionType().equals("SELL")) 
				sell.put(key, t);
			else if(t.getTransactionType().equals("BUY"))
				buy.put(key, t);
		}
		
		intradayTransaction();
	}
}
