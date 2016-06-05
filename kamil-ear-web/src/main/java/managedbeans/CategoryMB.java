package managedbeans;

import facade.CategoryFacade;
import model.Category;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Kamil on 05.06.2016.
 */

@ManagedBean
@ApplicationScoped
public class CategoryMB {

    @Inject
    private CategoryFacade categoryFacade;

    private Category category = new Category();

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public List<Category> getCategories() {
        return categoryFacade.findAll();
    }

    public void updateCategory () {
        categoryFacade.update(category);
    }

    public void deleteCategory () {
        categoryFacade.delete(category);
    }

    public void createCategory () {
        categoryFacade.save(category);
    }
}
