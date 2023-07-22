package mas.masfinalproject.Service;

import lombok.RequiredArgsConstructor;
import mas.masfinalproject.model.Menu;
import mas.masfinalproject.model.MenuItem;
import mas.masfinalproject.repository.MenuItemRepository;
import mas.masfinalproject.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Long menuId) {
        return menuRepository.findById(menuId).orElse(null);
    }

    public List<MenuItem> getMenuItemsByMenu(Long menuId) {
        return menuItemRepository.findByMenu_Id(menuId);
    }

    public MenuItem getMenuItemByID(Long id){
        return menuItemRepository.findById(id).orElse(null);
    }


}
