package com.kandarp.pjp2_week2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class FindWeekNumberHandler implements IOperationsHandler {

	@Override
	public void handleOperation(Locale locale) throws IOException {
		String filename= "history.txt";
		FileWriter fw = new FileWriter(filename,true);
		
		System.out.println("Enter Date (yyyy-mm-dd): ");
		LocalDate d1 = LocalDate.parse(Scan.sc.next());
		
		fw.write("Enter Date (yyyy-mm-dd): \n" );
		fw.write("Date entered:" + d1 + "\n" );
		
		System.out.println(d1.get(WeekFields.of(locale).weekOfYear()));
		
		fw.write(d1.get(WeekFields.of(locale).weekOfYear()));
		fw.close();
	}

}
