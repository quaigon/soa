package facade;

import dao.CategoryDAO;
import model.Category;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Kamil on 05.06.2016.
 */
public class CategoryFacadeImpl implements CategoryFacade {

    @Inject
    private CategoryDAO categoryDAO;

    @Override
    public void save(Category category) {
        categoryDAO.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryDAO.update(category);
    }

    @Override
    public void delete(Category category) {
        categoryDAO.delete(category.getId(), Category.class);
    }

    @Override
    public Category find(int entityID) {
        return categoryDAO.find(entityID);
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }
}
