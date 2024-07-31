package com.edgaritzak.TimeDoesNotWaitServiceApplication.services;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class TimeCalculatorService {
	
	public boolean validateCheckbox(boolean optionsDays,boolean optionsWeeks,boolean optionsMonths,
			boolean optionsYears,boolean optionsAll) {
		return (optionsDays||optionsWeeks||optionsMonths||optionsYears||optionsAll);
	}
	
	public int calculateDaysBetween(String startDate, String endDate){
		//dd/mm/yyyy
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime date1 = LocalDate.parse(startDate, dtf).atStartOfDay();
		LocalDateTime date2 = LocalDate.parse(endDate, dtf).atStartOfDay();
		long dateDiff = Duration.between(date1,date2).toDays();
		return (int) dateDiff;
	}
	
	public int calculateWeeksBetween(String startDate, String endDate){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime date1 = LocalDate.parse(startDate, dtf).atStartOfDay();
		LocalDateTime date2 = LocalDate.parse(endDate, dtf).atStartOfDay();
		long dateDiff = ChronoUnit.WEEKS.between(date1,date2);
		return (int) dateDiff;
	}
	public int calculateMonthsBetween(String startDate, String endDate){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime date1 = LocalDate.parse(startDate, dtf).atStartOfDay();
		LocalDateTime date2 = LocalDate.parse(endDate, dtf).atStartOfDay();
		float dateDiff = ChronoUnit.MONTHS.between(date1,date2);
		return (int) dateDiff;
	}
	public int calculateYearsBetween(String startDate, String endDate){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime date1 = LocalDate.parse(startDate, dtf).atStartOfDay();
		LocalDateTime date2 = LocalDate.parse(endDate, dtf).atStartOfDay();
		float dateDiff = ChronoUnit.YEARS.between(date1,date2);
		return (int) dateDiff;
	}
	public String calculateDaysMonthsYearsBetween(String startDate, String endDate){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse(startDate, dtf);
		LocalDate date2 = LocalDate.parse(endDate, dtf);
		Period periodDiff = Period.between(date1,date2);
		return periodDiff.getDays()+"/"+periodDiff.getMonths()+"/"+periodDiff.getYears();
	}
	
}
