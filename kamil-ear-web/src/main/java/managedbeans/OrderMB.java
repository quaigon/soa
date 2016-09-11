package managedbeans;

import com.sun.org.apache.xpath.internal.operations.Or;
import facade.OrderFacade;
import model.Dish;
import model.Order;
import model.OrderStatus;
import model.User;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
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

    private OrderStatus newStatus;

    private Order lastOrder;

    @Inject
    private UserMB userMB;

    private String deliverer;

    public void addUser(User user) {
        order.setUser(user);
    }

    public void addDish(Dish dish) {
        cart.add(dish);
    }

    public void makeOrder() {
        Date date = new Date();
        order.setDate(date);
        User user = userMB.getCurrentUser();
        order.setUser(user);
        order.setOrderedDishes(cart);
        order.setOrderStatus(OrderStatus.ORDERED);
        orderFacade.save(order);
        cart.clear();
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

    public List<Order> getOrders() {
        if (userMB.isCustomer()) {
            return orderFacade.findOrderByUser(userMB.getCurrentUser());
        } else if (userMB.isDeliverer()) {
            List<Order> orders = orderFacade.findOrderByStatus(OrderStatus.TODELIVER);
            orders.addAll(orderFacade.findOrderByStatus(OrderStatus.DELIVERING));
            List<Order> deliverOrders = new ArrayList<>();
            if (orders == null) {
                return null;
            }
            for (Order order1 : orders) {
                if (order1.getDeliverer() == null) {
                    break;
                }
                if(order1.getDeliverer().getName().equals(userMB.getCurrentUser().getName())) {
                    deliverOrders.add(order1);
                }
            }
            return deliverOrders;
        } else {
            return orderFacade.findAll();
        }
    }

    public double calculateCost(Order order) {
        double res = 0;
        if (order == null) {
            return res;
        }
        for (Dish dish : order.getOrderedDishes()) {
            res += dish.getCost();
        }

        return res;
    }

    public OrderStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(OrderStatus newStatus) {
        this.newStatus = newStatus;
    }

    public OrderStatus[] getOrderStatuses() {
        OrderStatus [] orderStatuses = OrderStatus.values();

        if (userMB.isStaff()) {
            return new OrderStatus[] { OrderStatus.INPROGRESS, OrderStatus.TODELIVER};
        }
         if (userMB.isDeliverer()) {
            return new OrderStatus[] { OrderStatus.DELIVERED, OrderStatus.DELIVERING};
        }

        return orderStatuses;
    }

    public void changeOrderStatus(Order order) {
        order.setOrderStatus(newStatus);
        orderFacade.update(order);
    }

    public void addDeliverer(Order order) {
        User del = userMB.getUserByName(deliverer);
        order.setDeliverer(del);
        orderFacade.update(order);
    }

    public List<Order> getOrdersByStatus(OrderStatus orderStatus) {
        return orderFacade.findOrderByStatus(orderStatus);
    }

    public void showMessage(String cost) {
        FacesMessage message = new FacesMessage(cost);

        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

    public String getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(String deliverer) {
        this.deliverer = deliverer;
    }

}
