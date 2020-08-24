package com.kandarp.pjp2_week2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FindADateHandler implements IOperationsHandler {
	
	private LocalDate givenDate;
	private int choice;
	private int addch;
	private int subch;
	private int n;
	
	public FindADateHandler() {
		super();
		this.givenDate = LocalDate.MIN;
		this.choice = 0;
		this.addch = 0;
		this.subch = 0;
		this.n = -1;
	}
	
	
	public LocalDate getGivenDate() {
		return givenDate;
	}

	public void setGivenDate(LocalDate givenDate) {
		this.givenDate = givenDate;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public int getAddch() {
		return addch;
	}

	public void setAddch(int addch) {
		this.addch = addch;
	}

	public int getSubch() {
		return subch;
	}

	public void setSubch(int subch) {
		this.subch = subch;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

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
	public LocalDate handleOperation(Locale locale) throws IOException {
		
			String filename= "history.txt";
			FileWriter fw = new FileWriter(filename,true);
			
			if(this.givenDate == LocalDate.MIN) {
				System.out.println("Enter a Date (yyyy-mm-dd): ");
				this.givenDate = LocalDate.parse(Scan.sc.next());
			}
			
			fw.write("Enter a Date (yyyy-mm-dd): \n");
			fw.write("Date entered: " + this.givenDate + "\n");
		
			Map<Integer, String> addsub = new HashMap<>();
		
			addsub.put(1, "Find a date after "+ this.givenDate);
			addsub.put(2, "Find a date before "+ this.givenDate);
		
			if(this.choice == 0) {
				System.out.println("Choose option from below: ");
				addsub.forEach((k, v) -> System.out.println(k + " " + v));
				this.choice = Scan.sc.nextInt();
			}
			
			fw.write("Choose option from below: \n");
			addsub.forEach((k, v) -> {
				try {
					fw.write(k + " " + v + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			fw.write("Choice entered: "+ this.choice + "\n");
		
			Map<Integer, String> ops = new HashMap<>();
		
			ops.put(1, "Day(s)");
			ops.put(2, "Week(s)");
			ops.put(3, "Month(s)");
		
			if(this.choice == 1) {
				
				if(this.addch==0) {
					System.out.println("Choose units to be added from below: ");
					ops.forEach((k, v) -> System.out.println(k + ": " + v));
					this.addch = Scan.sc.nextInt();
				}
				
				fw.write("Choose units to be added from below: \n");
				ops.forEach((k, v) -> {
					try {
						fw.write(k + ": " + v + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				fw.write("Choice entered: " + this.addch + "\n");
				
				if(this.n == -1) {
					System.out.println("Enter " + ops.get(this.addch) + " to be added: ");
					this.n = Scan.sc.nextInt();
				}
			
				fw.write("Enter " + ops.get(this.addch) + " to be added: \n");
				fw.write("Value entered: " + n + "\n");
			
				Map<Integer, LocalDate> findDateMapAdd = new HashMap<>();
				findDateMapAdd.put(1, addDays(givenDate, n));
				findDateMapAdd.put(2, addWeeks(givenDate, n));
				findDateMapAdd.put(3, addMonths(givenDate, n));
			
				LocalDate finalDate = findDateMapAdd.get(this.addch);
			
				System.out.println("Final Date after adding " + n + " " + ops.get(this.addch) + " is " + finalDate
					.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",locale)));
				
				fw.write("Final Date after adding " + n + " " + ops.get(this.addch) + " is " + finalDate
					.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",locale)) + "\n");
			
				fw.close();
				
				return finalDate;
				
			} else if(this.choice == 2) {
				
				if(this.subch == 0) {
					System.out.println("Choose units to be subtracted from below: ");
					ops.forEach((k, v) -> System.out.println(k + ": " + v));
					this.subch = Scan.sc.nextInt();
				}
				
				fw.write("Choose units to be subtracted from below: \n");
				ops.forEach((k, v) -> {
					try {
						fw.write(k + ": " + v + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				fw.write("Choice entered: " + this.subch + "\n");
				
				if(this.n == -1) {
					System.out.println("Enter " + ops.get(this.subch) + " to be subtracted: ");
					this.n = Scan.sc.nextInt();
				}
			
				fw.write("Enter " + ops.get(this.subch) + " to be subtracted: \n");
				fw.write("Value entered: " + n + "\n");
			
				Map<Integer, LocalDate> findDateMapSub = new HashMap<>();
				findDateMapSub.put(1, subDays(givenDate, n));
				findDateMapSub.put(2, subWeeks(givenDate, n));
				findDateMapSub.put(3, subMonths(givenDate, n));
			
				LocalDate finalDate = findDateMapSub.get(this.subch);
				System.out.println("Final Date after adding " + n + " " + ops.get(this.subch) + " is " + finalDate
					.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",locale)));
				
				fw.write("Final Date after subtracting " + n + " " + ops.get(this.subch) + " is " + finalDate
						.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",locale)) + "\n");
				
				fw.close();
				
				return finalDate;
			
			} else {
				System.out.println("INVALID CHOICE");
				fw.write("INVALID CHOICE \n");
				fw.close();
				return LocalDate.MIN;
			}
		} 

}
