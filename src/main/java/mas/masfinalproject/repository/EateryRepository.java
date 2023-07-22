package mas.masfinalproject.repository;

import mas.masfinalproject.model.Eatery;
import mas.masfinalproject.model.EateryType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EateryRepository extends CrudRepository<Eatery,Long> {
    List<Eatery> findBySpecialities(String speciality);

    @Query("SELECT e FROM Eatery e ORDER BY e.name")
    List<Eatery> findOrderedByName();

}
