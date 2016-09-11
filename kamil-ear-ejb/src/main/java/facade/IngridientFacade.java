package facade;

import model.Ingridient;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Kamil on 10.09.2016.
 */
@Local
public interface IngridientFacade  {
    void save(Ingridient item);

    Ingridient update(Ingridient item);

    void delete(Ingridient item);

    Ingridient find(int itemId);

    List<Ingridient> findAll();
}
