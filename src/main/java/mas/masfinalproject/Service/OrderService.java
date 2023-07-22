package mas.masfinalproject.Service;

import lombok.RequiredArgsConstructor;
import mas.masfinalproject.model.MenuItem;
import mas.masfinalproject.model.OrderClass;
import mas.masfinalproject.model.OrderedDish;
import mas.masfinalproject.repository.MenuItemRepository;
import mas.masfinalproject.repository.OrderDishRepository;
import mas.masfinalproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final MenuItemRepository menuItemRepository;
    private final OrderDishRepository orderDishRepository;
    private OrderClass currentOrder;

    @Autowired
    public OrderService(OrderRepository orderRepository, MenuItemRepository menuItemRepository,OrderDishRepository orderDishRepository) {
        this.orderRepository = orderRepository;
        this.menuItemRepository = menuItemRepository;
        this.orderDishRepository=orderDishRepository;
    }

    public void addOrderedDish(OrderedDish orderedDish) {
        MenuItem menuItem = menuItemRepository.findById(orderedDish.getMenuItem().getId()).orElseThrow(NoSuchElementException::new);
        orderedDish.setMenuItem(menuItem);

        if (currentOrder == null) {
            currentOrder = new OrderClass();
//            currentOrder.setId(100L);
            currentOrder.setOrderDateTime(LocalDateTime.now());
            currentOrder.setOrderedDishes(new HashSet<>());
//            orderRepository.save(currentOrder);
        }
        orderedDish.setOrderClass(currentOrder);
        currentOrder.getOrderedDishes().add(orderedDish);
//        orderDishRepository.save(orderedDish);
    }

    public OrderClass getOrder() {
        return currentOrder;
    }

    public Set<OrderedDish> getOrderedDishes() {
        return currentOrder.getOrderedDishes();
    }


    public void saveOrder(OrderClass order) {
        orderRepository.save(order);
//        currentOrder = null;
    }
}
