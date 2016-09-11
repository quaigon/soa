package dao;

import model.Order;

/**
 * Created by Kamil on 11.09.2016.
 */
public class OrderDAO extends GenericDAO<Order> {
    public OrderDAO() {
        super(Order.class);
    }
}
