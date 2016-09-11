package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kamil on 05.06.2016.
 */

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dishId;

    private String name;

    private double cost;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Ingridient> ingridientList;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Category category = new Category();

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int id) {
        this.dishId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Ingridient> getIngridientList() {
        return ingridientList;
    }

    public void setIngridientList(List<Ingridient> ingridientList) {
        this.ingridientList = ingridientList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        return dishId == dish.dishId;

    }

    @Override
    public int hashCode() {
        return dishId;
    }
}
