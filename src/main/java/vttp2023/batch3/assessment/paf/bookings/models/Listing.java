package vttp2023.batch3.assessment.paf.bookings.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Listing {
    
    @NotNull(message = "country cannot be null")
    @NotEmpty(message = "country cannot be empty")
    private String country;

    @Size(min=1, max=10, message = "Can only have between 1 and 10 persons inclusive")
    private Integer numberOfPerson;

    @Size(min=1, max=10000, message = "price only between 1 to 10000 inclusive")
    private double minPrice;

    @Size(min=1, max=10000, message = "price only between 1 to 10000 inclusive")
    private double maxPrice;

    private String street;
    private String url;
    private double price;
}
