package facade;

import dao.DishDAO;
import dao.IngridientDao;
import model.Ingridient;

import javax.ejb.Local;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Kamil on 10.09.2016.
 */
public class IngridientFacadeImpl implements IngridientFacade {

    @Inject
    private IngridientDao ingridientDao;

    @Override
    public void save(Ingridient item) {
        ingridientDao.save(item);
    }

    @Override
    public Ingridient update(Ingridient item) {
        return ingridientDao.update(item);
    }

    @Override
    public void delete(Ingridient item) {
        ingridientDao.delete(item.getIngridientId(), Ingridient.class);
    }

    @Override
    public Ingridient find(int itemId) {
        return ingridientDao.find(itemId);
    }

    @Override
    public List<Ingridient> findAll() {
        return ingridientDao.findAll();
    }
}
