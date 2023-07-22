package mas.masfinalproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

//inheritance
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@ToString
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "name is mandatory")
    @Size(min=1, max = 255)
    private String name;

    @NotBlank(message = "name is mandatory")
    @Size(min=1, max = 255)
    private String surname;

    @NotBlank(message = "phone number is mandatory")
    @Pattern(regexp = "\\d+" , message = "Phone number should be only digits")
    @Size(min=9,max =9,message = "The length should be 9")
    private String phone_number;

    //person orderClass
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<OrderClass> makeOrders = new HashSet<>();
}
