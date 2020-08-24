package com.kandarp.pjp2_week2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FindADateHandler implements IOperationsHandler {
	
	static public LocalDate addDays(LocalDate givenDate, int n) {
		return givenDate.plusDays(n);
	}
	
	static public LocalDate addWeeks(LocalDate givenDate, int n) {
		return givenDate.plusWeeks(n);
	}

	static public LocalDate addMonths(LocalDate givenDate, int n) {
		return givenDate.plusMonths(n);
	}
	
	static public LocalDate subDays(LocalDate givenDate, int n) {
		return givenDate.minusDays(n);
	}
	
	static public LocalDate subWeeks(LocalDate givenDate, int n) {
		return givenDate.minusWeeks(n);
	}

	static public LocalDate subMonths(LocalDate givenDate, int n) {
		return givenDate.minusMonths(n);
	}
	
	static public LocalDate addYears(LocalDate givenDate, int n) {
		return givenDate.plusYears(n);
	}
	
	static public LocalDate subYears(LocalDate givenDate, int n) {
		return givenDate.minusYears(n);
	}

	@Override
	public void handleOperation(Locale locale) throws IOException {
		
			String filename= "history.txt";
			FileWriter fw = new FileWriter(filename,true);
			
			System.out.println("Enter a Date (yyyy-mm-dd): ");
			LocalDate givenDate = LocalDate.parse(Scan.sc.next());
			
			fw.write("Enter a Date (yyyy-mm-dd): \n");
			fw.write("Date entered: " + givenDate + "\n");
		
			Map<Integer, String> addsub = new HashMap<>();
		
			addsub.put(1, "Find a date after "+ givenDate);
			addsub.put(2, "Find a date before "+ givenDate);
		
			System.out.println("Choose option from below: ");
			addsub.forEach((k, v) -> System.out.println(k + " " + v));
			int choice = Scan.sc.nextInt();
			
			fw.write("Choose option from below: \n");
			addsub.forEach((k, v) -> {
				try {
					fw.write(k + " " + v + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			fw.write("Choice entered: "+ choice + "\n");
		
			Map<Integer, String> ops = new HashMap<>();
		
			ops.put(1, "Day(s)");
			ops.put(2, "Week(s)");
			ops.put(3, "Month(s)");
		
			if(choice == 1) {
				System.out.println("Choose units to be added from below: ");
				ops.forEach((k, v) -> System.out.println(k + ": " + v));
				int addch = Scan.sc.nextInt();
				
				fw.write("Choose units to be added from below: \n");
				ops.forEach((k, v) -> {
					try {
						fw.write(k + ": " + v + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				fw.write("Choice entered: " + addch + "\n");
				
				
				System.out.println("Enter " + ops.get(addch) + " to be added: ");
				int n = Scan.sc.nextInt();
			
				fw.write("Enter " + ops.get(addch) + " to be added: \n");
				fw.write("Value entered: " + n + "\n");
			
				Map<Integer, LocalDate> findDateMapAdd = new HashMap<>();
				findDateMapAdd.put(1, addDays(givenDate, n));
				findDateMapAdd.put(2, addWeeks(givenDate, n));
				findDateMapAdd.put(3, addMonths(givenDate, n));
			
				LocalDate finalDate = findDateMapAdd.get(addch);
			
				System.out.println("Final Date after adding " + n + " " + ops.get(addch) + " is " + finalDate
					.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",locale)));
				
				fw.write("Final Date after adding " + n + " " + ops.get(addch) + " is " + finalDate
					.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",locale)) + "\n");
			
				fw.close();
				
			} else if(choice == 2) {
				
				System.out.println("Choose units to be subtracted from below: ");
				ops.forEach((k, v) -> System.out.println(k + ": " + v));
				int subch = Scan.sc.nextInt();
				
				fw.write("Choose units to be subtracted from below: \n");
				ops.forEach((k, v) -> {
					try {
						fw.write(k + ": " + v + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				fw.write("Choice entered: " + subch + "\n");
				
				System.out.println("Enter " + ops.get(subch) + " to be subtracted: ");
				int n = Scan.sc.nextInt();
			
				fw.write("Enter " + ops.get(subch) + " to be subtracted: \n");
				fw.write("Value entered: " + n + "\n");
			
				Map<Integer, LocalDate> findDateMapSub = new HashMap<>();
				findDateMapSub.put(1, subDays(givenDate, n));
				findDateMapSub.put(2, subWeeks(givenDate, n));
				findDateMapSub.put(3, subMonths(givenDate, n));
			
				LocalDate finalDate = findDateMapSub.get(subch);
				System.out.println("Final Date after adding " + n + " " + ops.get(subch) + " is " + finalDate
					.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",locale)));
				
				fw.write("Final Date after subtracting " + n + " " + ops.get(subch) + " is " + finalDate
						.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",locale)) + "\n");
				
				fw.close();
			
			} else {
				System.out.println("INVALID CHOICE");
				fw.write("INVALID CHOICE \n");
				fw.close();
				return;
			}
		} 

}
