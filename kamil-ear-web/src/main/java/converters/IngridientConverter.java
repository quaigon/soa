package converters;

import dao.IngridientDao;
import facade.IngridientFacade;
import facade.IngridientFacadeImpl;
import model.Ingridient;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kamil on 10.09.2016.
 */

@ManagedBean(name = "mbean")
public class IngridientConverter implements Converter {

    @Inject
    IngridientDao ingridientDao;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Map<String, Object> paramters = new HashMap();
        paramters.put("name", s);

        Object object = ingridientDao.find(Integer.parseInt(s));
        return object;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Ingridient ingridient =((Ingridient) o);
        return String.valueOf(ingridient.getIngridientId());
    }
}
