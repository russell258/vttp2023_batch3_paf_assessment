package vttp2023.batch3.assessment.paf.bookings.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingDetailsIndividual {
    private String accId;
    private String description;
    private String street;
    private String suburb;
    private String country;
    private String image;
    private double price;
    private String amenities;
}
