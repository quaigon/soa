package facade;

import model.Dish;
import model.Order;
import model.OrderStatus;
import model.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Kamil on 11.09.2016.
 */
@Local
public interface OrderFacade {
    void save(Order order);

    Order update(Order category);

    void delete(Order order);

    Order find(int entityID);

    List<Order> findAll();

    List<Order> findOrderByUser (User user);

    List<Order> findOrderByStatus (OrderStatus orderStatus);

    List<Order> findOrderByDish(Dish dish);
}
