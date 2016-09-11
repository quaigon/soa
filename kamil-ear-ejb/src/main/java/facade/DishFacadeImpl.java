package facade;

import dao.DishDAO;
import model.Dish;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Kamil on 10.09.2016.
 */
public class DishFacadeImpl implements DishFacade {
    @Inject
    private DishDAO dishDAO;


    @Override
    public void save(Dish dish) {
        dishDAO.save(dish);
    }

    @Override
    public Dish update(Dish dish) {
        return dishDAO.update(dish);
    }

    @Override
    public void delete(Dish dish) {
        dishDAO.delete(dish.getDishId(), Dish.class);
    }

    @Override
    public Dish find(int entityID) {
        return dishDAO.find(entityID);
    }

    @Override
    public List<Dish> findAll() {
        return dishDAO.findAll();
    }
}
