package mas.masfinalproject.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Waiter extends Employee {
    @Min(0)
    private double tip;

    @Override
    public double calculateIncome() {
        return getSalary()+tip;
    }
}
