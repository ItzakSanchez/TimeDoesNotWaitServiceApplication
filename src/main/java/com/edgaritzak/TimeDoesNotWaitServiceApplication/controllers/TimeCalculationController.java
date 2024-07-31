package com.edgaritzak.TimeDoesNotWaitServiceApplication.controllers;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.edgaritzak.TimeDoesNotWaitServiceApplication.services.TimeCalculatorService;


@Controller
public class TimeCalculationController {
	
	@Autowired
	TimeCalculatorService service;
	
	@RequestMapping("/")
	public String showIndexPage(Model model) {
		return "index";
	}
	
	@PostMapping("/")
	public String indexPage(Model model, @RequestParam String startDate,@RequestParam String endDate,
			@RequestParam boolean optionsDays,@RequestParam boolean optionsWeeks,@RequestParam boolean optionsMonths,
			@RequestParam boolean optionsYears, @RequestParam boolean optionsAll) {	
		
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("optionsDays", optionsDays);
		model.addAttribute("optionsWeeks", optionsWeeks);
		model.addAttribute("optionsMonths", optionsMonths);
		model.addAttribute("optionsYears", optionsYears);
		model.addAttribute("optionsAll", optionsAll);
		if (service.validateCheckbox(optionsDays, optionsWeeks, optionsMonths, optionsYears, optionsAll)) { //IF AT LEAST ONE CHECKBOX IS SELECTED
			if(optionsDays) {
				int days =service.calculateDaysBetween(startDate, endDate);
				model.addAttribute("days", days);
			}
			
			if(optionsWeeks) {
				int weeks =service.calculateWeeksBetween(startDate, endDate);
				model.addAttribute("weeks", weeks);
			}
			
			if(optionsMonths) {
				int months =service.calculateMonthsBetween(startDate, endDate);
				model.addAttribute("months", months);
			}
			
			if(optionsYears) {
				int years =service.calculateYearsBetween(startDate, endDate);
				model.addAttribute("years", years);
			}
			
			if(optionsAll) {
				String DaysMonthsYears =service.calculateDaysMonthsYearsBetween(startDate, endDate);
				String allDays =  DaysMonthsYears.split("/",3)[0];
				String allMonths =  DaysMonthsYears.split("/",3)[1];
				String allYears =  DaysMonthsYears.split("/",3)[2];
				//model.addAttribute("days", days);
			}
			
		} else {
			model.addAttribute("errorMessage", "You must select at least 1 checkbox");
			return "index";
		}
		return "results";
	}
	
	
	@GetMapping("/results")
	public String showResults() {
		return "results";
	}
}
