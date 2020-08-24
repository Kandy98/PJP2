package com.kandarp.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.kandarp.pjp2_week2.DurationBetweenDatesHandler;
import com.kandarp.pjp2_week2.FindADateHandler;

class mainTest {

	@Test
	void durationBetweenDatesTest() {
		DurationBetweenDatesHandler obj = new DurationBetweenDatesHandler();
		obj.setD1(LocalDate.of(2020, 10, 12));
		obj.setD2(LocalDate.of(2020, 10, 14));
		
		try {
			assertEquals("0 0 2", obj.handleOperation(Locale.ENGLISH));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void findADateTest() {
		FindADateHandler obj = new FindADateHandler();
		obj.setGivenDate(LocalDate.of(2020, 8, 24));
		obj.setAddch(1);;
		obj.setChoice(1);
		obj.setN(4);
		
		try {
			assertEquals(LocalDate.of(2020, 8, 28), obj.handleOperation(Locale.ENGLISH));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
