package facade;

import model.Category;
import model.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Kamil on 10.09.2016.
 */
@Local
public interface UserFacade {
    void save(User user);

    User update(User user);

    void delete(User user);

    User find(int entityID);

    List<User> findAll();

    User findUserByUsername(String username);
}
