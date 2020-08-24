package com.kandarp.pjp2_week2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FindDayOfTheWeekHandler implements IOperationsHandler {

	@Override
	public String handleOperation(Locale locale) throws IOException {
		
		String filename= "history.txt";
		FileWriter fw = new FileWriter(filename,true);
			
		System.out.println("Enter Date (yyyy-mm-dd): ");
		LocalDate d1 = LocalDate.parse(Scan.sc.next());
			
			
		fw.write("Enter Date (yyyy-mm-dd): \n") ;
		fw.write("Date Entered :" + d1 + "\n");
		
		System.out.println(d1.format(DateTimeFormatter.ofPattern("EEEE", locale)));
		fw.write(d1.format(DateTimeFormatter.ofPattern("EEEE", locale)) + "\n");
			
		fw.close();
		
		return d1.format(DateTimeFormatter.ofPattern("EEEE", locale));
	}

}
