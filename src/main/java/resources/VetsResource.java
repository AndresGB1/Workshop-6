package resources;

import resources.pojos.Vet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/User/{username}/vets")
public class VetsResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") String Username) {

        List<Vet> vet = new ArrayList<Vet>();

        vet.add(new Vet(Username, "cristian", "callefalsa123", "los andes"));
        vet.add(new Vet(Username, "estebanu", "el campin", "cerca de la u nacional"));

        return Response.ok()
                .entity(vet)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("username") String Username, Vet vet) {


        return Response.status(Response.Status.CREATED)
                .entity(vet)
                .build();
    }
}


