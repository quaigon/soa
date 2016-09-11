package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Kamil on 10.09.2016.
 */
@Entity
@Table(name = "orders")
@NamedQueries(
        @NamedQuery(name = "orderByUser", query = "SELECT o FROM Order o WHERE o.User.name LIKE :name")
)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int orderId;

    @OneToOne(cascade = CascadeType.PERSIST)
    private User User = new User();

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Dish> orderedDishes;

    private Date date;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public model.User getUser() {
        return User;
    }

    public void setUser(model.User user) {
        User = user;
    }

    public List<Dish> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(List<Dish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addDish(Dish dish) {
        orderedDishes.add(dish);
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
