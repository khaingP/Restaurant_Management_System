package mas.masfinalproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Address {

    @NotBlank(message = "street is  necessary")
    @Size(min = 2 , max  = 255)
    private String street;

    @NotBlank(message = "building is  necessary")
    @Size(min = 2 , max  = 255)
    private String building;

    @Column(nullable = true)
    private String apartment;

    @NotBlank(message = "zipcode is  necessary")
    @Size(min = 2 , max  = 255)
    private String zipCode;

    @NotBlank(message = "city is  necessary")
    @Size(min = 2 , max  = 255)
    private String city;
}
