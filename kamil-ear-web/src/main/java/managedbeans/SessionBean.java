package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Kamil on 11.09.2016.
 */
@ManagedBean
@SessionScoped
public class SessionBean {

    public void logout() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        request.getSession().invalidate();
        try {
            fc.getExternalContext().redirect("http://localhost:8080/soa/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
