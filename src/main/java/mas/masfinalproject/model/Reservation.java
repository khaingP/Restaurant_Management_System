package mas.masfinalproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
//@Table(uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"customer_id","eatery_id","datetime"})
//})
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Future
    private LocalDateTime dateTime;

    @Min(1)
    private int numOfPeople;

    //association with attribute
    //customer-reservation-eatery
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    @NotNull
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "eatery_id",nullable = false)
    @NotNull
    private Eatery eatery;
}
