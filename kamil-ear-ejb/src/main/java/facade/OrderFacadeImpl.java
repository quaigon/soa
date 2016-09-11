package facade;

import dao.OrderDAO;
import model.Order;
import model.User;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil on 11.09.2016.
 */
public class OrderFacadeImpl implements OrderFacade {

    @Inject
    private OrderDAO orderDAO;

    @Override
    public void save(Order order) {
        orderDAO.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderDAO.update(order);
    }

    @Override
    public void delete(Order order) {
        orderDAO.delete(order, Order.class);
    }

    @Override
    public Order find(int entityID) {
        return orderDAO.find(entityID);
    }

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public List<Order> findOrderByUser(User user) {
        Map<String, Object> paramters = new HashMap();
        paramters.put("name", user.getName());

        return orderDAO.findResults("orderByUsername", paramters);
    }
}
