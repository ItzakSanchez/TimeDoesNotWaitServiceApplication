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
