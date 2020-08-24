package com.kandarp.pjp2_week2;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class DisplayHistoryHandler implements IOperationsHandler {

	@Override
	public LocalDate handleOperation(Locale locale) throws IOException {
		File myObj = new File("history.txt");
		Scanner myReader = new Scanner(myObj);
	      
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			System.out.println(data);
		}
		
		LocalDate localDate = LocalDate.now();
		myReader.close();
		
		return localDate;
	}

}
