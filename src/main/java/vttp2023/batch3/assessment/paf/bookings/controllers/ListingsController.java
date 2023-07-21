package vttp2023.batch3.assessment.paf.bookings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2023.batch3.assessment.paf.bookings.models.Listing;
import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
import vttp2023.batch3.assessment.paf.bookings.models.ListingDetailsIndividual;
import vttp2023.batch3.assessment.paf.bookings.services.BookingService;
import vttp2023.batch3.assessment.paf.bookings.services.ListingsService;

@Controller
@RequestMapping
public class ListingsController {

	@Autowired
	ListingsService svc;

	@Autowired
	BookingService bSvc;

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
		
		//for ListingDetails ld :  ldList each in thymeleaf to populate
		model.addAttribute("ldList", ldList);
		
		//to go back again from view 3 to view 2
		model.addAttribute("country", country);
		model.addAttribute("numberOfPerson", numberOfPerson);
		model.addAttribute("minPrice", minPrice);
		model.addAttribute("maxPrice", maxPrice);
		
		return "listingPage";
	}

	//TODO: Task 4
	@GetMapping(path="/{object-id}")
	public String individualDetails(Model model, @PathVariable("object-id") String objectId){
		ListingDetailsIndividual indv = new ListingDetailsIndividual();
		indv = svc.findListingDetailsById(objectId);
		model.addAttribute("indv", indv);

		return "bookingPage";
	}

	//TODO: Task 5
	// @PostMapping(path="/booking")
	// public ResponseEntity<Boolean> bookingReservation()
	// Boolean bookSuccess = bSvc.bookReservation(...)
	// Response Entity Controller, return new ResponseEntity<Boolean>(bookSuccess,HttpStatus.OK)
	//extract resv_id and return 

}
