package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2023.batch3.assessment.paf.bookings.models.Listing;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;

@Service
public class ListingsService {

	@Autowired
	ListingsRepository repo;

	//TODO: Task 2

	public List<String> countryList(){
		return repo.countryList();
	}

	public List<Listing> findListingsService(String country, Integer numberOfPerson, double minPrice, double maxPrice){
		List<Listing> r = repo.findListings(country, numberOfPerson, minPrice, maxPrice);
		// if (r.isEmpty()){
			// see if can do this in controller
		// }

		return r;
	}
	
	//TODO: Task 3


	//TODO: Task 4
	

	//TODO: Task 5


}
