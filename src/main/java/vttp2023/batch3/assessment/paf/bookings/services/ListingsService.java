package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
import vttp2023.batch3.assessment.paf.bookings.models.ListingDetailsIndividual;
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
		if (r.isEmpty()){
			throw new IllegalArgumentException("No Listings found");
		}
		return r;
	}
	
	//TODO: Task 3

	//list of documents of listings retrieved with minimum attributes into pojo
	public List<ListingDetails> findListingsPriceDesc(String country, Integer numberOfPerson, double minPrice, double maxPrice){
		List<ListingDetails> listDetails = repo.findListingsPriceDesc(country, numberOfPerson, minPrice, maxPrice);
		// if (listDetails.isEmpty()){
		// 	throw new IllegalArgumentException("No listings found");
		// }
		return listDetails;
	}


	//TODO: Task 4
	
	//individual listing details retrieved by id
	public ListingDetailsIndividual findListingDetailsById(String id){
		ListingDetailsIndividual indv = repo.getIndividualDetailsById(id);
		if (indv==null){
			throw new IllegalArgumentException("There was no details found for this listing");
		}
		return indv;
	}

	//TODO: Task 5


}
