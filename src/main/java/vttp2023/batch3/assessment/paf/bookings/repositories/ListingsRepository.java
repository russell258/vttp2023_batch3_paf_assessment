package vttp2023.batch3.assessment.paf.bookings.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vttp2023.batch3.assessment.paf.bookings.models.Listing;

@Repository
public class ListingsRepository {
	@Autowired
	private MongoTemplate mongo;

	public static final String F_country = "address.country";
	public static final String F_accommodates = "accommodates";
	public static final String F_price = "price";

	//TODO: Task 2

	// get list of countries
	//db.listing.distinct('address.country')
	public List<String> countryList(){
		List<String> countries = mongo.findDistinct(new Query(), F_country,"listing", String.class);
		// List<String> countries = new ArrayList<>();
		// for (Document c:countriesDoc){
		// 	countries.add(c.getString("country"));
		// 	System.out.println(c.getString("country"));
		// }
		System.out.println(countries);

		return countries;
	}

	// db.listing.find({
	// 	$and:[
	// 	   {'address.country': 'Australia'},
	// 	   {accommodates: 2},
	// 	   {price:{$gte:1}},
	// 	   {price:{$lte:10000}}
	// 	]
	// 	})
	public List<Listing> findListings(String country, Integer numberOfPerson, double minPrice, double maxPrice){
		
		//create filter
		Criteria c = Criteria.where(F_country).is(country);
		c.and(F_accommodates).is(numberOfPerson);
		c.and(F_price).gte(minPrice);
		c.and(F_price).lte(maxPrice);

		Query q = Query.query(c);

		List<Document> listDoc = mongo.find(q, Document.class,"listing");

		List<Listing> listpojo = new ArrayList<>(); 

		//loop through listDoc with all attributes and create new pojo 
		for (Document d: listDoc){
			//create new pojo rtrieving name,price,image,details
			Listing l = new Listing();
			l.setStreet(d.getString("address.street"));
			l.setPrice(d.getDouble("price"));
			l.setUrl(d.getString("images.picture_url"));
			listpojo.add(l);
		}

		return listpojo;
	}
	
	//TODO: Task 3


	//TODO: Task 4
	

	//TODO: Task 5


}
