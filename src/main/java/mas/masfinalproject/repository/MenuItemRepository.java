package mas.masfinalproject.repository;

import mas.masfinalproject.model.MenuItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuItemRepository extends CrudRepository<MenuItem,Long> {
//    List<MenuItem> findById(Long id);
    List<MenuItem> findByMenu_Id(Long  Menuid);
}
