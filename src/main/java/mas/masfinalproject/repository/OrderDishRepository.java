package mas.masfinalproject.repository;

import mas.masfinalproject.model.Eatery;
import mas.masfinalproject.model.OrderedDish;
import org.springframework.data.repository.CrudRepository;

public interface OrderDishRepository extends CrudRepository<OrderedDish,Long> {
}
