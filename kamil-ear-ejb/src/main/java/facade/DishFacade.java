package facade;

import model.Category;
import model.Dish;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Kamil on 10.09.2016.
 */
@Local
public interface DishFacade {
    void save(Dish dish);

    Dish update(Dish dish);

    void delete(Dish dish);

    Dish find(int entityID);

    List<Dish> findAll();
}
