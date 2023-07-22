package mas.masfinalproject.Controller;
import mas.masfinalproject.Service.MenuService;
import mas.masfinalproject.Service.OrderService;
import mas.masfinalproject.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Controller
public class MenuController {

    private MenuService menuService;
    private OrderService orderService;

    public MenuController(MenuService menuService, OrderService orderService)  {
        this.menuService  = menuService;
        this.orderService = orderService;
    }

    @GetMapping("/menu")
    public String showMenuItems(Model model) {
        List<Menu> menus = menuService.getAllMenus();
        model.addAttribute("menus", menus);
        return "menu";
    }

    @GetMapping("/menu/{id}")
    public String showMenuItems(@PathVariable("id") Long menuId, Model model) {
        Menu menu = menuService.getMenuById(menuId);
        List<MenuItem> menuItems = menuService.getMenuItemsByMenu(menuId);
        model.addAttribute("menu", menu);
        model.addAttribute("menuItems", menuItems);
        return "menu";
    }

    @PostMapping("/addToCart")
    public String addToOrder(@RequestParam("quantity") int quantity, @RequestParam("itemId") Long itemId) {
        MenuItem menuItem = menuService.getMenuItemByID(itemId);
        OrderedDish orderedDish = new OrderedDish();
        orderedDish.setMenuItem(menuItem);
        orderedDish.setQuantity(quantity);
        orderService.addOrderedDish(orderedDish);
        return "redirect:/checkout";
    }

    @GetMapping("/checkout")
    public String showCheckoutPage(Model model) {
        Set<OrderedDish> orderedDishes = orderService.getOrderedDishes();
        double totalAmount =calculateTotalAmount(orderedDishes);
        model.addAttribute("orderedDishes", orderedDishes);
        model.addAttribute("totalAmount", totalAmount);

        return "checkout";
    }
    @GetMapping("/placeOrder")
    public String placeOrder(@RequestParam("selectType") String orderType,
                             @RequestParam("paymentMethod") String paymentMethod
                            ) {

        Set<OrderedDish> orderedDishes = orderService.getOrderedDishes();
        double totalAmount =calculateTotalAmount(orderedDishes);
        OrderClass order = new OrderClass();

        OrderType order_type;
        switch (orderType){
            case "Standard" :{
                order_type= OrderType.Standard;
            }
            case "Express"  :{
                order_type= OrderType.Express;
            }
            default : {
                order_type= OrderType.Standard;
            }
        }
        order.setOrderType(order_type);
        Payment payment;
        switch (paymentMethod){
            case "Cash" :{
                payment= Payment.Cash;
            }
            case "Online"  :{
                payment= Payment.Online;
            }
            default : {
                payment= Payment.Cash;
            }
        }
        order.setPayment(payment);
        order.setTotalAmount(totalAmount);
        order.setOrderDateTime(LocalDateTime.now());

        if (orderType.equals("Standard")) {
            order.setWaitingTime(30);
            totalAmount +=10.0;
            order.setTotalAmount(totalAmount);
        } else if (orderType.equals("Express")) {
            order.setFees(10.0);
        }
        orderService.saveOrder(order);
        return "orderConfirmation";
    }
    private double calculateTotalAmount(Set<OrderedDish> orderedDishes) {
        double totalAmount = 0.0;
        for (OrderedDish orderedDish : orderedDishes) {
            int quantity = orderedDish.getQuantity();
            double price = orderedDish.getMenuItem().getPrice();
            totalAmount += quantity * price;
        }
        return totalAmount;
    }




}
