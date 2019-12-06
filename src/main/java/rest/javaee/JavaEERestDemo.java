package rest.javaee;

import jpa.hibernate.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * created by Nikita_Ermakov at 12/5/2019
 */
@Path("/javaee")
public class JavaEERestDemo {

    @GET
    @Path("/getString")
    @Produces(MediaType.APPLICATION_JSON)
    public String getString() {
        return "simple string";
    }

    @GET
    @Path("/echo")
    public String echo(@QueryParam("msg") String message) {
        return message == null ? "empty message" : message;
    }

    @GET
    @Path("/echo/{msg}")
    public String pathVariableEcho(@PathParam("msg") String message) {
        return message;
    }

    @POST
    @Path("/getUserName")
    @Consumes(MediaType.APPLICATION_XML)
    public String getUserName(User user) {
        return user == null ? "empty user" : user.getName();
    }
}