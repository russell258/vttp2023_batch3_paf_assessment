package vttp2023.batch3.assessment.paf.bookings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2023.batch3.assessment.paf.bookings.services.ListingsService;

@Controller
@RequestMapping
public class ListingsController {

	@Autowired
	ListingsService svc;

	//TODO: Task 2
	@GetMapping(path="/")
	public String landingPage(Model model){
		List<String> countries = svc.countryList();
		System.out.println(countries);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		model.addAttribute("countries", countries);
		return "landingpage";
	}	
	
	//TODO: Task 3


	//TODO: Task 4
	

	//TODO: Task 5


}
