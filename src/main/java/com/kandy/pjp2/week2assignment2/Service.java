package com.kandy.pjp2.week2assignment2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@RestController
@RequestMapping("/")
public class Service {
	
	@GetMapping("/transaction/{file_name}")
	public List<SummaryReport> createSummaryReport(@PathVariable(value = "file_name") String file_name) 
			throws IOException {
		
		// Application Supports .CSV files, can be extend
		// further for other file types
		String fileWithExtension = file_name + ".csv";  
		
		FileReader fileReader = new FileReader(fileWithExtension);
		CSVReader csvReader = new CSVReaderBuilder(fileReader) 
                .withSkipLines(1) 
                .build();
		
		List<String[]> allData = csvReader.readAll();
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		
		for (String[] row : allData) { 
			List<String> transaction = new ArrayList<String>();
			
			for (String cell : row) {
				System.out.print(cell + "\t");
				transaction.add(cell);
			}
			System.out.println();
			
			Transaction transactionObject = new Transaction(transaction);
			transactions.add(transactionObject);
		}
		
		FeeCalculator feeCalculator = new FeeCalculator();
		feeCalculator.calculateFee(transactions);
		
		GenerateSummary generateSummary = new GenerateSummary();
		List<SummaryReport> summaryReport = generateSummary.generateSummary(transactions);
//		Collections.sort(summaryReport, (o1, o2) -> o1.getClientId().compareTo(o2.getClientId()));
		Collections.sort(summaryReport, new Comp());
		
		return summaryReport;
	}
}
