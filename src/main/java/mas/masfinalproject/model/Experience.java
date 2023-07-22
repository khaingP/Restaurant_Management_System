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
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name= "experience_speciality",joinColumns = @JoinColumn(name="Experience_ID"))
    @Builder.Default
    private Set<String> specialities=new HashSet<>();

    @Min(message = "in months", value = 1)
    private int duration;

    @NotBlank(message = "position is mandatory")
    @Size(min=2,max =255)
    private String position;

    // cook -experience (XOR).
    @ManyToOne
    @JoinColumn(name = "cook_id" )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Cook cook;

}
