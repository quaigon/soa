package rest;

import com.sun.org.apache.regexp.internal.RE;
import facade.DishFacade;
import model.Dish;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Kamil on 11.09.2016.
 */
@Stateless
@Path("menu")
public class Rest {

    @Inject
    DishFacade dishFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSth() {
        List<Dish> dishes = dishFacade.findAll();

        return Response.ok(dishes).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getMenuItem(@PathParam("id") int id) {
        Dish dish = dishFacade.find(id);

        return Response.ok(dish).build();
    }
}