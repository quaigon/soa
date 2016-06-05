package dao;

import model.Category;

import javax.ejb.Stateless;

/**
 * Created by Kamil on 05.06.2016.
 */

@Stateless
public class CategoryDAO extends GenericDAO<Category> {

    public CategoryDAO() {
        super(Category.class);
    }


}
