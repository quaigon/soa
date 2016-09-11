package managedbeans;

import facade.UserFacade;
import model.User;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Kamil on 10.09.2016.
 */
@ManagedBean
@ApplicationScoped
public class UserMB {
    private static String MANAGER = "manager";
    private static String CUSTOMER = "customer";

    @Inject
    private UserFacade userFacade;

    private User user = new User();

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public List<User> getUsers() {
        return userFacade.findAll();
    }

    public void updateUser() {
        userFacade.update(user);
    }

    public void deleteUser() {
        userFacade.delete(user);
    }

    public void createuser() {
        userFacade.save(user);
        user = new User();

    }

    public boolean isManager() {
        User user = userFacade.findUserByUsername(getUserName());

        return user.getRole().equals(MANAGER);
    }

    public boolean isCustomer() {
        User user = userFacade.findUserByUsername(getUserName());

        return user.getRole().equals(CUSTOMER);
    }

    private String getUserName() {
        String username = null;

        FacesContext facesContext = FacesContext.getCurrentInstance();

        username = facesContext.getExternalContext().getRemoteUser();

        return username;
    }
}
