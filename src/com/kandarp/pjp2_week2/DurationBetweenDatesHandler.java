package com.kandarp.pjp2_week2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class DurationBetweenDatesHandler implements IOperationsHandler {

	@Override
	public void handleOperation(Locale locale) throws IOException {	
		
		String filename= "history.txt";
		FileWriter fw = new FileWriter(filename,true);
		
		System.out.println("Enter dates to find the duration between them");
		System.out.println("Enter Date 1 (yyyy-mm-dd): ");
		LocalDate d1 = LocalDate.parse(Scan.sc.next());
		System.out.println("Enter Date 2 (yyyy-mm-dd): ");
		LocalDate d2 = LocalDate.parse(Scan.sc.next());
		
		fw.write("Enter dates to find the duration between them \n");
		fw.write("Enter Date 1 (yyyy-mm-dd): " + d1 + "\n");
		fw.write("Enter Date 2 (yyyy-mm-dd): " + d2 + "\n");
		
		
		int days = Period.between(d1, d2).getDays();
		int weeks = days/7;
		days = days%7;
		int months = Period.between(d1, d2).getMonths();
		
		System.out.printf("The duration between the dates is:\n%d months %d weeks and %d days \n", 
				months, weeks, days);
		
		fw.write("The duration between the dates is:\n" + months + "months" + weeks + "weeks and" + days + "days \n" );
		fw.close();
	}

}
