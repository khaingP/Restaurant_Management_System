package mas.masfinalproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@ToString
public class OrderClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    @Column(nullable = false,updatable = false)
    private OrderType orderType;

    @Min(0)
    private double totalAmount;

    @NotNull
    private LocalDateTime orderDateTime;

    @Enumerated(EnumType.STRING)
    private Payment payment;

    //for  standard
    @Min(message = "in minutes",value = 0)
    @Column(nullable = true)
    private Integer waitingTime;

    //for express
    @Min(0)
    private Double fees;

    //flattening
    public OrderClass(Long id, OrderType orderType, double totalAmount, LocalDateTime orderDateTime, Payment payment, Integer waitingTime, Double fees) {
        setId(id);
        setOrderType(orderType);
        setTotalAmount(totalAmount);
        setOrderDateTime(orderDateTime);
        setPayment(payment);
        if(orderType.equals(OrderType.Express)) {
           setFees(fees);
        }
        if(orderType.equals(OrderType.Standard)){
            setWaitingTime(waitingTime);
        }
    }

    //orderClass-employee
    @ManyToOne
    @JoinColumn(name = "employee_id" )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee employee;

    //orderClass-person
    @ManyToOne
    @JoinColumn(name = "person_id" )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Person user;

    //association with attribute
    //orderClass-ordereddish-menuitems
    @OneToMany(mappedBy = "orderClass" ,cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<OrderedDish> orderedDishes= new HashSet<>();
}
