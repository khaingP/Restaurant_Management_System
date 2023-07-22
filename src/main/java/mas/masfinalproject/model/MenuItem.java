package mas.masfinalproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "name is necessary")
    @Size(min= 2, max =255)
    private String name;

    @Min(1)
    private double price;

    @NotBlank(message = "description is necessary")
    @Size(min= 2, max =255)
    private String description;

    //menuitem-menu
    @ManyToOne
    @JoinColumn(name = "menu_id" )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Menu menu;

    //association with attribute
    //orderClass-ordereddish-menuitems
    @OneToMany(mappedBy = "menuItem" ,cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<OrderedDish> orderedDishes= new HashSet<>();

}
