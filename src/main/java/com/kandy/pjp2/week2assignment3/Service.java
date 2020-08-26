package com.kandy.pjp2.week2assignment3;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class Service {

	public static void main(String[] args) throws IOException {
		String input = args[0];
		String output = args[1];
		
		FileReader fileReader = new FileReader(input);
		CSVReader csvReader = new CSVReaderBuilder(fileReader) 
                .withSkipLines(1) 
                .build();
		
		List<String[]> allData = csvReader.readAll();
		List<IncomeReport> incomeReport = new ArrayList<IncomeReport>();
		
		for (String[] row : allData) { 
			List<String> incomeEntry = new ArrayList<String>();
			
			for (String cell : row) {
				incomeEntry.add(cell);
			}
			
			IncomeReport incomeReportObject = new IncomeReport(incomeEntry);
			incomeReport.add(incomeReportObject);
		}
		
		GenerateSummary generateSummary = new GenerateSummary();
		generateSummary.summaryGenerator(incomeReport, output);
		
	}

}
