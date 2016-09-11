package dao;

import model.Order;

import javax.ejb.Stateless;

/**
 * Created by Kamil on 11.09.2016.
 */
@Stateless
public class OrderDAO extends GenericDAO<Order> {
    public OrderDAO() {
        super(Order.class);
    }
}
