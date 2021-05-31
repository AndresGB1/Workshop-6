package resources;

import resources.pojos.Case;
import resources.pojos.Vet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/pet/{pet_id}/cases")
public class CasesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("pet_id") Integer Petid, Date date) {

        List<Case> cases = new ArrayList<Case>();
        cases.add(new Case(1, date, "robo", "me robaron mi perro",Petid));


        return Response.ok()
                .entity(cases)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("pet_id") Integer Petid, Case cases) {

        cases.setCase_id(2);
        return Response.status(Response.Status.CREATED)
                .entity(cases)
                .build();
    }
}