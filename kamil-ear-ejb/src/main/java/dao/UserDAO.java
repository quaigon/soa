package dao;

import model.User;

import javax.ejb.Stateless;

/**
 * Created by Kamil on 10.09.2016.
 */
@Stateless
public class UserDAO extends GenericDAO<User> {

    public UserDAO() {
        super(User.class);
    }
}

