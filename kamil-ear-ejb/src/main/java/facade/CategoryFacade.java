package facade;

import model.Category;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Kamil on 05.06.2016.
 */
@Local
public interface CategoryFacade {
    void save(Category category);

    Category update(Category category);

    void delete(Category category);

    Category find(int entityID);

    List<Category> findAll();
}
