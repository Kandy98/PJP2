package com.kandy.pjp2.week2assignment2;

import java.util.Comparator;

public class Comp implements Comparator<SummaryReport> {

	@Override
	public int compare(SummaryReport o1, SummaryReport o2) {
		if(o1.getClientId().compareTo(o2.getClientId())>=0) {
			if(o1.getTransactionType().compareTo(o2.getTransactionType())>=0) {
				if(o1.getPriorityFlag().compareTo(o2.getPriorityFlag())>=0) 
					return 1;
				return 0;
			}
			return 0;
		}
		return 0;
	}

}
