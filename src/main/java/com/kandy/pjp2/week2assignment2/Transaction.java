package com.kandy.pjp2.week2assignment2;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class Transaction {
	
	private String externalTransactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private String transactionDate;
	private double marketValue;
	private String priorityFlag;
	private int processingFee;
	
	public Transaction() {}
	
	public Transaction(List<String> transaction) {		
		this.externalTransactionId = transaction.get(0);
		this.clientId = transaction.get(1);
		this.securityId = transaction.get(2);
		this.transactionType = transaction.get(3);
		this.transactionDate = transaction.get(4);
		this.marketValue = Double.parseDouble(transaction.get(5));
		this.priorityFlag = transaction.get(6);
		this.processingFee = 0;
	}
	
	public Transaction(String externalTransactioId, String clientId, String securityId, String transactionType,
			String transactionDate, double marketValue, String priorityFlag) {
		super();
		this.externalTransactionId = externalTransactioId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.marketValue = marketValue;
		this.priorityFlag = priorityFlag;
		this.processingFee = 0;
	}
	
	public String getExternalTransactioId() {
		return externalTransactionId;
	}
	public void setExternalTransactioId(String externalTransactioId) {
		this.externalTransactionId = externalTransactioId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}
	public String getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}

	public int getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(int processingFee) {
		this.processingFee = processingFee;
	}
}
