package converters;

import dao.CategoryDAO;
import model.Category;
import model.Ingridient;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

/**
 * Created by Kamil on 11.09.2016.
 */
@ManagedBean(name = "categoryMBean")
public class CategoryConverter implements Converter {

    @Inject
    CategoryDAO categoryDAO;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Object object = categoryDAO.find(Integer.parseInt(s));
        return object;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Category category =((Category) o);
        return String.valueOf(category.getCategoryId());
    }
}
