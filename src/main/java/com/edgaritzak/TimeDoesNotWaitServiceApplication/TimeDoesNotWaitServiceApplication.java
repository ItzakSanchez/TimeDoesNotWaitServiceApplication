package com.edgaritzak.TimeDoesNotWaitServiceApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.edgaritzak.TimeDoesNotWaitServiceApplication.services.TimeCalculatorService;

@SpringBootApplication
public class TimeDoesNotWaitServiceApplication {

	public static void main(String[] args) {
		
		TimeCalculatorService tcs = new TimeCalculatorService();
		//System.out.println(tcs.calculateDaysBetween("01/01/2024","02/02/2024")+" DAYS");
		//System.out.println(tcs.calculateWeeksBetween("01/01/2024","01/02/2024")+" COMPLETED WEEKS");
		//System.out.println(tcs.calculateMonthsBetween("01/01/2024","01/02/2026")+" COMPLETED MONTHS");
		//String timeDifference = tcs.calculateDaysMonthsYearsBetween("20/10/2024","01/02/2025");
		/*System.out.println("Full: "+timeDifference);
		for(String s :(timeDifference.split("/",3))){
			System.out.print(s+", ");
		}
		System.out.println("Days: "+ timeDifference.split("/",3)[0]);
		System.out.println("Months: "+ timeDifference.split("/",3)[1]);
		System.out.println("Years: "+ timeDifference.split("/",3)[2]);*/

		
		//SpringApplication.run(TimeDoesNotWaitServiceApplication.class, args);
	}

}
