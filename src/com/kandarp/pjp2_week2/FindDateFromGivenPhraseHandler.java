package com.kandarp.pjp2_week2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FindDateFromGivenPhraseHandler implements IOperationsHandler {

	@Override
	public void handleOperation(Locale locale) throws IOException {
		
		LocalDate currDate = LocalDate.now();
		
		Map<Integer, String> phrases = new HashMap<>();
		phrases.put(1, "today");
		phrases.put(2, "tomorrow");
		phrases.put(3, "day after tomorrow");
		phrases.put(4, "yesterday");
		phrases.put(5, "day before yesterday");
		phrases.put(6, "last week");
		phrases.put(7, "previous week");
		phrases.put(8, "next week");
		phrases.put(9, "next month");
		phrases.put(10, "next year");
		phrases.put(11, "last month");
		phrases.put(12, "last year");
		phrases.put(13, "month after");
		phrases.put(14, "month before");
		phrases.put(15, "weeks from now");
		phrases.put(16, "days from now");
		phrases.put(17, "months from now");
		phrases.put(18, "years from now");
		phrases.put(19, "days earlier");
		phrases.put(20, "weeks earlier");
		phrases.put(21, "months earlier");
		phrases.put(22, "years earlier");

		
 		int n = 0;
 		
 		String filename= "history.txt";
		FileWriter fw = new FileWriter(filename,true);
 		
 		String ch = "y";
 		while(ch.equals("y")) {
 			System.out.println("Enter a phrase below: ");
 			String phrase = Scan.sc.nextLine();
 			
			fw.write("Enter a phrase below: \n");
			fw.write("phrase enterd: " + phrase + "\n");
 			
 			String cleanPhrase = "";
 			String replaceNumString = "";
 			int phraseOption = -1;
	
 			for(String word: phrase.split(" ")) {
 				if(word.matches("^[0-9]*$")) {
 					n = Integer.parseInt(word);
 					replaceNumString = n + " ";
 					break;
 				}
 			}
 			
 			Map<Integer, LocalDate > phraseToDate= new HashMap<>();
 			phraseToDate.put(1, FindADateHandler.addDays(currDate, 0));
 			phraseToDate.put(2, FindADateHandler.addDays(currDate, 1));
 			phraseToDate.put(3, FindADateHandler.addDays(currDate, 2));
 			phraseToDate.put(4, FindADateHandler.subDays(currDate, 1));
 			phraseToDate.put(5, FindADateHandler.subDays(currDate, 2));
 			phraseToDate.put(6, FindADateHandler.subWeeks(currDate, 1));
 			phraseToDate.put(7, FindADateHandler.subWeeks(currDate, 1));
 			phraseToDate.put(8, FindADateHandler.addWeeks(currDate, 1));
 			phraseToDate.put(9, FindADateHandler.addMonths(currDate, 1));
 			phraseToDate.put(10, FindADateHandler.addYears(currDate, 1)); 
 			phraseToDate.put(11, FindADateHandler.subMonths(currDate, 1));
 			phraseToDate.put(12, FindADateHandler.subYears(currDate, 1));
 			phraseToDate.put(13, FindADateHandler.addMonths(currDate, 1));
 			phraseToDate.put(14, FindADateHandler.subMonths(currDate, 1));
 			phraseToDate.put(15, FindADateHandler.addWeeks(currDate, n));
 			phraseToDate.put(16, FindADateHandler.addDays(currDate, n));
 			phraseToDate.put(17, FindADateHandler.addMonths(currDate, n));
 			phraseToDate.put(18, FindADateHandler.addYears(currDate, n)); 
 			phraseToDate.put(19, FindADateHandler.subDays(currDate, n));
 			phraseToDate.put(20, FindADateHandler.subWeeks(currDate, n));
 			phraseToDate.put(21, FindADateHandler.subMonths(currDate, n));
 	 		phraseToDate.put(22, FindADateHandler.subYears(currDate, n));
 			
 			cleanPhrase = phrase.replaceAll(replaceNumString, "");
 			cleanPhrase = cleanPhrase.toLowerCase();
 		
 			LocalDate finalDate = null;
 			boolean isAMatch = false;
 			
 			for (Map.Entry<Integer,String> entry : phrases.entrySet()) {
 				if(entry.getValue().equals(cleanPhrase)) {
 					finalDate = phraseToDate.get(entry.getKey());
 					phraseOption = entry.getKey(); 
 					isAMatch = true;
 					break;
 				}
 			}
		
 			if(isAMatch) {
 				if(n==0) {
 					System.out.println(phrases.get(phraseOption) + ": " + finalDate
 							.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy", locale)));
 					
 					fw.write(phrases.get(phraseOption) + ": " + finalDate
 							.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy", locale)) + "\n" );
 				} 
 				else {
 					System.out.println(n + " " + phrases.get(phraseOption) + ": " + finalDate
 							.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy", locale)));
 					
 					fw.write(n + " " + phrases.get(phraseOption) + ": " + finalDate
 							.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy", locale)) + "\n");
 				}
 			} 
 			else {
 				System.out.println("INVALID PHRASE");
 				
 				fw.write("INVALID PHRASE \n");
 			}
 			
 			System.out.println("Want to enter another phrase? (y/n): ");
 			String choice = Scan.sc.next();
 			
 			fw.write("Want to enter another phrase? (y/n): \n");
 			fw.write("choice entered: " + choice + "\n");
 			
 			Scan.sc.nextLine();
 			if(choice.equals("n") || choice.equals("N"))
 				break;
 			else if(choice.equals("y") || choice.equals("Y"))
 				continue;
 			else {
 				System.out.println("INVALID CHOICE!! Exiting program.");
 				fw.write("INVALID CHOICE!! Exiting program. \n");
 				break;
 			}
 		}
 		
 		fw.close();
	}

}
