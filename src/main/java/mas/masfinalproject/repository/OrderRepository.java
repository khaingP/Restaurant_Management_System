package mas.masfinalproject.repository;

import mas.masfinalproject.model.Eatery;
import mas.masfinalproject.model.OrderClass;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderClass,Long> {
}
