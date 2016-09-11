package managedbeans;

import facade.CategoryFacade;
import facade.DishFacade;
import facade.IngridientFacade;
import facade.IngridientFacadeImpl;
import model.Category;
import model.Dish;
import model.Ingridient;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil on 10.09.2016.
 */
@ManagedBean
@ApplicationScoped
public class FoodMB {

    @Inject
    private IngridientFacade ingridientFacade;

    @Inject
    private DishFacade dishFacade;

    @Inject
    private CategoryFacade categoryFacade;

    @Inject
    private UserMB userMB;

    private Ingridient ingridient = new Ingridient();

    private List<Ingridient> selected = new ArrayList<>();

    private Dish dish = new Dish();

    private Category category;

    private Category newCategory = new Category();

    public List<Ingridient> getIngridients() {
        return ingridientFacade.findAll();
    }

    public void addIngridient() {
        ingridientFacade.save(ingridient);
        ingridient = new Ingridient();
    }


    public IngridientFacade getIngridientFacade() {
        return ingridientFacade;
    }

    public void setIngridientFacade(IngridientFacadeImpl ingridientFacade) {
        this.ingridientFacade = ingridientFacade;
    }

    public Ingridient getIngridient() {
        return ingridient;
    }

    public void setIngridient(Ingridient ingridient) {
        this.ingridient = ingridient;
    }

    public DishFacade getDishFacade() {
        return dishFacade;
    }

    public void setDishFacade(DishFacade dishFacade) {
        this.dishFacade = dishFacade;
    }

    public Dish getDish() {

        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public List<Ingridient> getSelected() {
        return selected;
    }

    public void setSelected(List<Ingridient> selected) {
        this.selected = selected;
    }

    public void addDish() {

        dish.setIngridientList(selected);
        dish.setCategory(category);
        dishFacade.save(dish);
        dish = new Dish();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addCategory() {
        categoryFacade.save(newCategory);
        newCategory = new Category();
    }

    public List<Category> getCategories() {
        return categoryFacade.findAll();
    }

    public Category getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(Category newCategory) {
        this.newCategory = newCategory;
    }

    public List<Dish> getDishes() {
        return dishFacade.findAll();
    }

    public void deleteDish(Dish dish) {
        if (dish != null) dishFacade.delete(dish);
    }
}
