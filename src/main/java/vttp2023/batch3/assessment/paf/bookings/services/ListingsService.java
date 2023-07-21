package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2023.batch3.assessment.paf.bookings.models.Listing;
import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;

@Service
public class ListingsService {

	@Autowired
	ListingsRepository repo;

	//TODO: Task 2

	//distinct list of countries
	public List<String> countryList(){
		return repo.countryList();
	}

	//list of documents of listings retrieved
	public List<Document> findListingsService(String country, Integer numberOfPerson, double minPrice, double maxPrice){
		List<Document> r = repo.findListings(country, numberOfPerson, minPrice, maxPrice);
		return r;
	}
	
	//TODO: Task 3

	//list of documents of listings retrieved with minimum attributes into pojo
	public List<ListingDetails> findListingsPriceDesc(String country, Integer numberOfPerson, double minPrice, double maxPrice){
		List<ListingDetails> listDetails = repo.findListingsPriceDesc(country, numberOfPerson, minPrice, maxPrice);
		return listDetails;
	}


	//TODO: Task 4
	

	//TODO: Task 5


}
