package mas.masfinalproject.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Eatery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min=2,max =255)
    private String name;

    @NotBlank(message = "phone number is mandatory")
    @Pattern(regexp = "\\d+" , message = "Phone number should be only digits")
    @Size(min=9,max =9,message = "The length should be 9")
    private String phone_number;

    //optional attribute
    @Column(nullable = true)
    private String website;

    @ElementCollection
    @NotEmpty
    private List<@Min(1) @Max(5) Integer> ratings;

    //Derived  Attribute
    @Transient
    public double getAverageRating() {
        int  total=0;
        for(int r  : ratings){
            total+=r;
        }
        return (double) total/ratings.size();
    }

    //complex  attribute
    @Embedded
    private Address address;


    @Column(updatable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    @ElementCollection()
    private Set<EateryType>types;

    //class attribute
    @Min(0)
    private static  int minCapacity=10;

    //for cafe
    @Column(nullable = true)
    private Boolean animalAllowed;

    //for  restaurant
    //multi-value
    @ElementCollection
    @CollectionTable(name= "restaurant_speciality",joinColumns = @JoinColumn(name="eatry_id"))
    @Builder.Default
    private Set<String> specialities=new HashSet<>();

    //for bar
    @Column(nullable = true)
    private Integer min_age;

    //checking the types and set attributes
    public Eatery(Set<EateryType> types, String name, String phoneNumber, String restaurantType, int minAge, boolean animalAllowed) {
        setTypes(types);
        setName(name);
        setPhone_number(phoneNumber);

        if (types.contains(EateryType.RESTAURANT)) {
            Set<String> specialities = new HashSet<>();
            specialities.add(restaurantType);
            setSpecialities(specialities);
        }

        if (types.contains(EateryType.BAR)) {
            setMin_age(minAge);
        }

        if (types.contains(EateryType.CAFE)) {
            setAnimalAllowed(animalAllowed);
        }
    }


    //eatery-employee  association
    @OneToMany(mappedBy = "worksAt",fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Employee> employees= new HashSet<>();

    //association with attribute
    //customer-reservation-eatery
    @OneToMany(mappedBy = "eatery" ,cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Reservation>  reservations;

    //composition
    //eatery-menu
    @OneToMany(mappedBy = "eatery",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Menu> menus = new HashSet<>();


}
