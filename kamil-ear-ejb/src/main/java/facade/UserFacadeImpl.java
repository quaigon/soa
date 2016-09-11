package facade;

import dao.CategoryDAO;
import dao.UserDAO;
import model.Category;
import model.User;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil on 10.09.2016.
 */
public class UserFacadeImpl implements UserFacade {

    @Inject
    private UserDAO userDAO;

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public User update(User user) {
        return userDAO.update(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user.getName(), User.class);
    }

    @Override
    public User find(int entityID) {
        return userDAO.find(entityID);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        Map<String, Object> paramters = new HashMap();
        paramters.put("name", username);

        return userDAO.findOneResult("userQuery", paramters);
    }
}
