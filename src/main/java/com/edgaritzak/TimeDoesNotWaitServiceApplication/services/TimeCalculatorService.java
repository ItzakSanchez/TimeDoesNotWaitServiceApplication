package com.edgaritzak.TimeDoesNotWaitServiceApplication.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TimeCalculatorService {
	
	public String parseDateddMMyyyy(String date)  {
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateAsDate;
		try {
			dateAsDate = inputFormat.parse(date);
			SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
			return outputFormat.format(dateAsDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error al transformar"+date+"\nException "+ e;
		}
        
	}
	
	public boolean validateDates(String startDate, String endDate) {
		DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			dtf.parse(startDate);
		}
		catch(Exception e){
			return false;
		}
		try {
			dtf.parse(endDate);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean validateCheckbox(boolean optionsDays,boolean optionsWeeks,boolean optionsMonths,
			boolean optionsYears,boolean optionsAll) {
		return (optionsDays||optionsWeeks||optionsMonths||optionsYears||optionsAll);
	}
	
	public int calculateDaysBetween(String startDate, String endDate){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime date1 = LocalDate.parse(startDate, dtf).atStartOfDay();
		LocalDateTime date2 = LocalDate.parse(endDate, dtf).atStartOfDay();
		long dateDiff = Duration.between(date1,date2).toDays();
		return (int) dateDiff;
	}
	
	public int calculateWeeksBetween(String startDate, String endDate){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime date1 = LocalDate.parse(startDate, dtf).atStartOfDay();
		LocalDateTime date2 = LocalDate.parse(endDate, dtf).atStartOfDay();
		long dateDiff = ChronoUnit.WEEKS.between(date1,date2);
		return (int) dateDiff;
	}
	
	public int calculateMonthsBetween(String startDate, String endDate){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime date1 = LocalDate.parse(startDate, dtf).atStartOfDay();
		LocalDateTime date2 = LocalDate.parse(endDate, dtf).atStartOfDay();
		float dateDiff = ChronoUnit.MONTHS.between(date1,date2);
		return (int) dateDiff;
	}
	
	public int calculateYearsBetween(String startDate, String endDate){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime date1 = LocalDate.parse(startDate, dtf).atStartOfDay();
		LocalDateTime date2 = LocalDate.parse(endDate, dtf).atStartOfDay();
		float dateDiff = ChronoUnit.YEARS.between(date1,date2);
		return (int) dateDiff;
	}
	
	public String calculateDaysMonthsYearsBetween(String startDate, String endDate){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date1 = LocalDate.parse(startDate, dtf);
		LocalDate date2 = LocalDate.parse(endDate, dtf);
		Period periodDiff = Period.between(date1,date2);
		return periodDiff.getDays()+"/"+periodDiff.getMonths()+"/"+periodDiff.getYears();
	}
}
