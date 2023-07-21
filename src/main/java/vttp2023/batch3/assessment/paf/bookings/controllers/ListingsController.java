package vttp2023.batch3.assessment.paf.bookings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2023.batch3.assessment.paf.bookings.models.Listing;
import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
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

		model.addAttribute("countries", countries);
		//get list of countries from distinct operator and put into dropdown select in landingPage countries input.
		return "landingPage";
	}	
	
	//TODO: Task 3
	@GetMapping(path="/search")
	public String searchPage(Model model, @RequestParam("country") String country, @RequestParam("numberOfPerson") Integer numberOfPerson,
						@RequestParam("minPrice") double minPrice, @RequestParam("maxPrice") double maxPrice){
		List<ListingDetails> ldList = svc.findListingsPriceDesc(country, numberOfPerson, minPrice, maxPrice);
		model.addAttribute("ldList", ldList);
	
		//for ListingDetails ld :  ldList each in thymeleaf to populate
		return "listingPage";
	}

	//TODO: Task 4
	@GetMapping(path="/{}")

	//TODO: Task 5


}
