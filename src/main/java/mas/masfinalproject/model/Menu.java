package mas.masfinalproject.model;

import jakarta.persistence.*;
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
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = " name is necessary")
    @Size(min=2, max=255)
    private String name;

    //composition
    //menu-eatery
    @ManyToOne(optional = false)
    @JoinColumn(name  = "eatery_id",nullable = false, updatable = false)
    private Eatery eatery;

    //menu-menuItem
    @OneToMany(mappedBy = "menu",fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<MenuItem> menuItems = new HashSet<>();
}
