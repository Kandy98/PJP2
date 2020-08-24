package com.kandarp.pjp2_week2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class Main {

	public static void main(String[] args)
    {
		Map<Integer, String> map = new HashMap<>();
		Map<Integer, String> locales = new HashMap<>();
		
		locales.put(1, "english");
		locales.put(2, "french");
		locales.put(3, "german");
		
		System.out.println("Choose a language: ");
		locales.forEach((k, v) -> System.out.println(k + ": " + v));
		int localeKey = Scan.sc.nextInt();
		Locale locale = Locale.ENGLISH;
		Scan.sc.nextLine();
		if(localeKey == 1)
			locale = Locale.ENGLISH;
		else if(localeKey == 2)
			locale = Locale.FRENCH;
		else if(localeKey == 3)
			locale = Locale.GERMAN;
		else {
			System.out.println("INVLID LANGUAGE CHOSEN. EXITING....");
			return;
		}
			
		
		map.put(1, "Duration between dates");
		map.put(2, "Find a date");
		map.put(3, "Find day of the week");
		map.put(4, "Find week number");
		map.put(5, "Find date from given phrase");
		map.put(6, "Display history");
		
		
		String ch = "y";
 		while(ch.equals("y")) {
 			System.out.println("Choose operation to be performed: ");
 			map.forEach((k, v) -> System.out.println(k + ": " + v));
		
 			Map<Integer, Object> operationHandlers = new HashMap<>();
 			operationHandlers.put(1, new DurationBetweenDatesHandler());
 			operationHandlers.put(2, new FindADateHandler());
 			operationHandlers.put(3, new FindDayOfTheWeekHandler());
 			operationHandlers.put(4, new FindWeekNumberHandler());
 			operationHandlers.put(5, new FindDateFromGivenPhraseHandler());
			operationHandlers.put(6, new DisplayHistoryHandler());
 			
 			int d1 = Scan.sc.nextInt();
 			Scan.sc.nextLine();
 			
 			if(d1>6 || d1<1) {
 				System.out.println("INVALID CHOICE!! Exiting program.");
 				return;
 			}
 			
 			try {
 				String filename= "history.txt";
 				FileWriter fw = new FileWriter(filename,true);
 				map.forEach((k, v) -> {
 					try {
 						fw.write(k + ": " + v + "\n");
 					} catch (IOException e) {
 						System.err.println("IOException: " + e.getMessage());
 						e.printStackTrace();
 					}
 				});
 				fw.write("Input Option :" + d1 + "\n");
 				
 				fw.close();
 			}
 			catch(IOException msg) {
 				System.err.println("IOException: " + msg.getMessage());
 			}
 			
			IOperationsHandler operation = (IOperationsHandler) operationHandlers.get(d1);
 					
 			try {
				Object obj = operation.handleOperation(locale);
			} catch (IOException e) {
				e.printStackTrace();
			}
 			
 			System.out.println("Exit program? (y/n): ");
 			String choice = Scan.sc.next();
 			Scan.sc.nextLine();
 			if(choice.equals("n") || choice.equals("N"))
 				continue;
 			else if(choice.equals("y") || choice.equals("Y"))
 				break;
 			else {
 				System.out.println("INVALID CHOICE!! Exiting program.");
 				break;
 			}
 		}
    }
}
