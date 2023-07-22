package mas.masfinalproject.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

//method
//dynamic salary
//inheritance
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract  class Employee extends Person {

    @Min(0)
    private double salary;

    //unique attribute
    @NotBlank(message = "PESEL is mandatory")
    @Pattern(regexp = "\\d+" , message = "Phone number should be only digits")
    @Size(min=11, max = 11,message = "The length should be 11")
    @Column(unique = true)
    private String PESEL;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public abstract double calculateIncome();

    //employee-eatery  association
    @ManyToOne
    @JoinColumn(name = "eatery_id" )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Eatery worksAt;

    //employee-orderClass
    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<OrderClass> checkOrders =new HashSet<>();



}