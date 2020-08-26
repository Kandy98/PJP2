package com.kandy.pjp2.week2assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateSummary {
	
	Map<String, SummaryReport> group = new HashMap<>();
	
	public List<SummaryReport> generateSummary(List<Transaction> transactions) {
		List<SummaryReport> summaryReport = new ArrayList<SummaryReport>();
		
		for(Transaction t: transactions) {
			String grouping = t.getClientId() 
					+ t.getTransactionType() 
					+ t.getTransactionDate() 
					+ t.getPriorityFlag();	
			
			if(group.containsKey(grouping) == false) {
				SummaryReport entry = new SummaryReport(t.getClientId(), t.getTransactionType(), 
						t.getTransactionDate(), t.getPriorityFlag(), t.getProcessingFee());
				
				group.put(grouping, entry);
			}
			else {
				int transactionProcessingFee = t.getProcessingFee();
				int existingProcessingFee = group.get(grouping).getProcessingFee();
				
				group.get(grouping).setProcessingFee(transactionProcessingFee + existingProcessingFee);
			}
		}
		
		group.forEach((k, v) -> {
			summaryReport.add(v);
		});
		
		return summaryReport;
	}
}
