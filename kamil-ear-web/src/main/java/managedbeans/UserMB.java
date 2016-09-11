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
    private static final String DELIVERER = "deliver";
    private static final String MANAGER = "manager";
    private static final String CUSTOMER = "customer";
    private static final String STAFF = "staff";

    @Inject
    private UserFacade userFacade;

    private User user = new User();

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public List<User> getUserByRole(String role) {
        List<User> users = null;

        return users;
    }

    public void createuser() {
        userFacade.save(user);
        user = new User();

    }

    public User getCurrentUser() {
        return userFacade.findUserByUsername(getUserName());
    }

    public boolean isManager() {
        User user = userFacade.findUserByUsername(getUserName());

        return user.getRole().equals(MANAGER);
    }

    public boolean isStaff() {
        User user = userFacade.findUserByUsername(getUserName());

        return user.getRole().equals(STAFF);
    }

    public boolean isCustomer() {
        User user = userFacade.findUserByUsername(getUserName());

        return user.getRole().equals(CUSTOMER);
    }
    public boolean isDeliverer() {
        User user = userFacade.findUserByUsername(getUserName());

        return user.getRole().equals(DELIVERER);
    }

    private String getUserName() {
        String username = null;

        FacesContext facesContext = FacesContext.getCurrentInstance();

        username = facesContext.getExternalContext().getRemoteUser();

        return username;
    }
}
