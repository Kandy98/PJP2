package com.kandy.pjp2.week2assignment2;


public class SummaryReport {
	private String clientId;
	private String transactionType;
	private String transactionDate;
	private String priorityFlag;
	private int processingFee;
	
	public SummaryReport() {}
	
	public SummaryReport(String clientId, String transactionType, String transactionDate, String priorityFlag,
			int processingFee) {
		super();
		this.clientId = clientId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.priorityFlag = priorityFlag;
		this.processingFee = processingFee;
	}
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
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
