package com.kandarp.pjp2_week2;

import java.time.*;

public class DateCalculator {
	LocalDate date;

	public DateCalculator() {}
	
	public DateCalculator(LocalDate date) {
		super();
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
