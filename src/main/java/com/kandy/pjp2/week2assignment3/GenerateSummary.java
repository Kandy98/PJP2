package com.kandy.pjp2.week2assignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVWriter;

public class GenerateSummary {
	
	private Map<String, Summary> map = new HashMap<String, Summary>();
	private List<Summary> summary = new ArrayList<Summary>();

	public void summaryGenerator(List<IncomeReport> incomeReport, String outputFile) throws IOException {
		
		for(IncomeReport i: incomeReport) {
			String key = "";
			String countryOrCity = "";
			if(i.getCountry().equals("")) {
				key = key + i.getCity();
				countryOrCity = i.getCity();
			}
			else {
				key = key + i.getCountry();
				countryOrCity = i.getCountry();
			}
			
			key = key + i.getGneder();
			float standardAvgIncome = CurrencyConversion
					.convertCurrency(i.getCurrency(), i.getAmount());
			
			if(map.containsKey(key) == false) {
				Summary summaryEntry = new Summary(countryOrCity, i.getGneder(), standardAvgIncome, 1);
				map.put(key, summaryEntry);
			} else {
				float existingAvgIncome = map.get(key).getAversgeIncome();
				int newEntryCount = map.get(key).getEntries() + 1;
				float newTotIncome = (existingAvgIncome + standardAvgIncome);
				
				map.get(key).setEntries(newEntryCount);
				map.get(key).setAversgeIncome(newTotIncome);
			}
		}
		
		map.forEach((k, v) -> {
			float totIncome = v.getAversgeIncome();
			v.setAversgeIncome(totIncome/v.getEntries());
			summary.add(v);
		});
		
		Collections.sort(summary, new Comp());
		
		printSummary(outputFile);
	}

	private void printSummary(String outputFile) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(outputFile));
		
		String[] headers = "Country/City,Gender,Avgerage Income(USD)".split(",");
		writer.writeNext(headers);
		
		for(Summary s: summary) {
			String[] entry = new String[3] ;
			entry[0] = s.getCountryOrCity();
			entry[1] = s.getGender();
			entry[2] = Float.toString(s.getAversgeIncome());
			
			writer.writeNext(entry);
		}
		
		writer.close();
	}

}
