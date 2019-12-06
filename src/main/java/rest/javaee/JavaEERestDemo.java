package rest.javaee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * created by Nikita_Ermakov at 12/5/2019
 */
@Path("/rest/javaee")
public class JavaEERestDemo {

    @GET
    @Path("/string")
    @Produces("text/plain")
    public String getString() {
        return "simple string";
    }
}
