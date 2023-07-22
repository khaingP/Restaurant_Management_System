package mas.masfinalproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class Customer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "username is necessary")
    @Size(min=2,max =255)
    private String username;

    @NotBlank(message = "password is necessary")
    @Size(min=8,max =128)
    private String password;

    //association with attribute
    //customer-reservation-eatery
    @OneToMany(mappedBy = "customer" ,cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Reservation> reservations;

}
