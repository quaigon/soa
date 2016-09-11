package dao;

import model.Ingridient;

import javax.ejb.Stateless;

/**
 * Created by Kamil on 10.09.2016.
 */
@Stateless
public class IngridientDao extends GenericDAO<Ingridient> {
    public IngridientDao() {
        super(Ingridient.class);
    }
}
