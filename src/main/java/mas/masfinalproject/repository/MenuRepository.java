package mas.masfinalproject.repository;

import mas.masfinalproject.model.Eatery;
import mas.masfinalproject.model.Menu;
import mas.masfinalproject.model.MenuItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuRepository extends CrudRepository<Menu,Long> {
    List<Menu> findAll( );

}
