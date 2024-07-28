package com.edgaritzak.TimeDoesNotWaitServiceApplication.services;

import org.springframework.stereotype.Service;

@Service
public class TimeCalculatorService {
	
	public boolean validateCheckbox(boolean optionsDays,boolean optionsWeeks,boolean optionsMonths,
			boolean optionsYears,boolean optionsAll) {
		return (optionsDays||optionsWeeks||optionsMonths||optionsYears||optionsAll);
	}
	
	public float calculateDaysUntilToday(String startDate, String endDate){
		return 1;
	}
	public float calculateWeeksUntilToday(String startDate, String endDate){
		return 1;
	}
	public float calculateMonthsUntilToday(String startDate, String endDate){
		return 1;
	}
	public float calculateYearsUntilToday(String startDate, String endDate){
		return 1;
	}
	public String calculateDaysMonthsYearsUntilToday(String startDate, String endDate){
		return "";
	}
	
}
