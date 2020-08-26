package com.kandy.pjp2.week2assignment3;

import java.util.Comparator;

public class Comp implements Comparator<Summary> {

	@Override
	public int compare(Summary o1, Summary o2) {
		
		if(o1.getCountryOrCity().equals(o2.getCountryOrCity())) {

			if (o1.getGender().equals(o2.getGender())) {
				
					return Float.toString(o1.getAversgeIncome())
							.compareTo(Float.toString(o2.getAversgeIncome()));
			}
			return o1.getGender().compareTo(o1.getGender());
		}

		return o1.getCountryOrCity().compareTo(o2.getCountryOrCity());
	}

}
