package managedbeans;

import facade.OrderFacade;
import model.Dish;
import model.Order;
import model.OrderStatus;
import model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kamil on 11.09.2016.
 */
@ManagedBean
@SessionScoped
public class OrderMB {

    @Inject
    private OrderFacade orderFacade;

    private Order order = new Order();

    private List<Dish> cart = new ArrayList<>();

    @Inject
    private UserMB userMB;

    public void addUser(User user) {
        order.setUser(user);
    }

    public void addDish(Dish dish) {
        cart.add(dish);
    }

    public void makeOrder() {
        Date date = new Date();
        order.setDate(date);
        order.setUser(userMB.getCurrentUser());
        order.setOrderedDishes(cart);
        order.setOrderStatus(OrderStatus.ORDERED);
        orderFacade.save(order);
    }

    public List<Dish> getCart() {
        return cart;
    }

    public void setCart(List<Dish> cart) {
        this.cart = cart;
    }

    public void removeFromCart(Dish dish) {
        cart.remove(dish);
    }
}
