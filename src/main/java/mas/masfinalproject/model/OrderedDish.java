package mas.masfinalproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"orderClass_id","menuItem_id"})
})
public class OrderedDish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(1)
    private int quantity;

    //optional attribute
    @Column(nullable = true)
    private String note;

    //association with attribute
    //orderClass-ordereddish-menuitems
    @ManyToOne
    @JoinColumn(name = "orderClass_id",nullable = false)
    @NotNull
    private OrderClass orderClass;

    @ManyToOne
    @JoinColumn(name = "menuItem_id",nullable = false)
    @NotNull
    private MenuItem menuItem;
}



