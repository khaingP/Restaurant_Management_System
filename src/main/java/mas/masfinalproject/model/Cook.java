package mas.masfinalproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Cook extends Employee {
    @Min(0)
    private double bonus;

    @NotBlank(message = "speciality is mandatory")
    @Size(min=1, max = 255)
    private String speciality;

    @Override
    public double calculateIncome() {
        return getSalary()+bonus;
    }

    @OneToMany(mappedBy = "cook",fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Experience> experiences= new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "training_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Training training;

}
