package managedbeans;

import facade.OrderFacade;
import model.Dish;
import model.Order;
import model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
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

    public void addUser(User user) {
        order.setUser(user);
    }

    public void addDish(Dish dish) {
        order.addDish(dish);
    }
}
