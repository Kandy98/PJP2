package com.kandarp.pjp2_week2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class DurationBetweenDatesHandler implements IOperationsHandler {
	
	private LocalDate d1, d2;

	public DurationBetweenDatesHandler() {
		super();
		this.d1 = LocalDate.MIN;
		this.d2 = LocalDate.MIN;
	}


	@Override
	public String handleOperation(Locale locale) throws IOException {	
		
		String filename= "history.txt";
		FileWriter fw = new FileWriter(filename,true);
		
		if(this.d1 == LocalDate.MIN && this.d2 == LocalDate.MIN) {
			System.out.println("Enter dates to find the duration between them");
			System.out.println("Enter Date 1 (yyyy-mm-dd): ");
			this.d1 = LocalDate.parse(Scan.sc.next());
			System.out.println("Enter Date 2 (yyyy-mm-dd): ");
			this.d2 = LocalDate.parse(Scan.sc.next());
		}
		
		fw.write("Enter dates to find the duration between them \n");
		fw.write("Enter Date 1 (yyyy-mm-dd): " + this.d1 + "\n");
		fw.write("Enter Date 2 (yyyy-mm-dd): " + this.d2 + "\n");
		
		
		int days = Period.between(d1, d2).getDays();
		int weeks = days/7;
		days = days%7;
		int months = Period.between(d1, d2).getMonths();
		
		System.out.printf("The duration between the dates is:\n%d months %d weeks and %d days \n", 
				months, weeks, days);
		
		fw.write("The duration between the dates is:\n" + months + "months" + weeks + "weeks and" + days + "days \n" );
		fw.close();
		
		return months + " " + weeks + " " + days;
	}
	

	public LocalDate getD1() {
		return d1;
	}

	public void setD1(LocalDate d1) {
		this.d1 = d1;
	}

	public LocalDate getD2() {
		return d2;
	}

	public void setD2(LocalDate d2) {
		this.d2 = d2;
	}

}
