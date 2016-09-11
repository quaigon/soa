package managedbeans;

import facade.*;
import model.Category;
import model.Dish;
import model.Ingridient;
import model.Order;

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

    @Inject
    private OrderFacade orderFacade;

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
        if (dish != null) {
            List<Order> orders = orderFacade.findAll();

            List<Order> ordersToDelete = new ArrayList<>();

            for (Order order : orders) {
                if(order.getOrderedDishes().contains(dish)) {
                    ordersToDelete.add(order);
                }
            }

            for (Order order : ordersToDelete) {
                orderFacade.delete(order);
            }

            dishFacade.delete(dish);
        }
    }

    public List<Dish> getMostOrdered() {
        List<Dish> mostOrdered = null;




        return mostOrdered;
    }
}
