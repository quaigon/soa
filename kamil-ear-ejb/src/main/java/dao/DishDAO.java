package dao;

import model.Dish;

import javax.ejb.Stateless;

/**
 * Created by Kamil on 10.09.2016.
 */
@Stateless
public class DishDAO extends GenericDAO <Dish> {

    public DishDAO() {
        super(Dish.class);
    }
}
