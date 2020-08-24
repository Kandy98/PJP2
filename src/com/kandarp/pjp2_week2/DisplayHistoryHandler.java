package com.kandarp.pjp2_week2;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class DisplayHistoryHandler implements IOperationsHandler {

	@Override
	public void handleOperation(Locale locale) throws IOException {
		File myObj = new File("history.txt");
		Scanner myReader = new Scanner(myObj);
	      
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			System.out.println(data);
		}
		
		myReader.close();
	}

}
