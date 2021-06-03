package resources;

import resources.pojos.ComparatorLocation;
import resources.pojos.Owner;
import resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("Owner")
public class OwnersResource {
    @GET
    @Path("/User/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") String Username) {
        List<Owner> owners = new ArrayList<Owner>();
        owners.add(new Owner(Username, 1, "cristian", "cdsanchezm@unbosque.edu.co", "a"));
        owners.add(new Owner(Username, 2, "andres", "pongan aca sus correos vagos", "b"));
        owners.add(new Owner(Username, 3, "esteban c", "pongan aca sus correos vagos", "k"));
        owners.add(new Owner(Username, 4, "pau", "pongan aca sus correos vagos", "c"));
        owners.add(new Owner(Username, 5, "esteban u", "pongan aca sus correos vagos", "l"));
        return Response.ok()
                .entity(owners)
                .build();
    }
    @GET
    @Path("/Location/User/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listz(@PathParam("username") String Username) {
        List<Owner> owners = new ArrayList<Owner>();
        owners.add(new Owner(Username, 1, "cristian", "cdsanchezm@unbosque.edu.co", "a"));
        owners.add(new Owner(Username, 2, "andres", "pongan aca sus correos vagos", "b"));
        owners.add(new Owner(Username, 3, "esteban c", "pongan aca sus correos vagos", "k"));
        owners.add(new Owner(Username, 4, "pau", "pongan aca sus correos vagos", "c"));
        owners.add(new Owner(Username, 5, "esteban u", "pongan aca sus correos vagos", "l"));
        Collections.sort(owners,new ComparatorLocation());
        return Response.ok()
                .entity(owners)
                .build();
    }
    @POST
    @Path("/User/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("username") String Username, Owner owner) {

            owner.setPerson_id(6);

        return Response.status(Response.Status.CREATED)
                .entity(owner)
                .build();
    }
    @GET
    @Path("/Location/User/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listP(@PathParam("username") int ownerId, String value, int filter){

        List<Pet> pets = new ArrayList<Pet>();
        Random random = new Random();

        String[] size = {"grande", "pequeño", "mediano", "muy grande"};
        String[] specie = {"perro", "gato"};
        String[] sex = {"femenino", "masculino"};
        String[] names = {"json", "stan", "masacre", "danger", "aslan", "tayson", "galleta", "copito"};

        for (int i=0; i<20; i++){
            int id = random.nextInt(10000);

            if (i%2 == 0){
                pets.add(new Pet(1, "1234567891", "pet" + i, specie[random.nextInt(specie.length)], "pet_race",
                        size[random.nextInt(size.length)], sex[random.nextInt(sex.length)], "null", ownerId ));
            }else{
                pets.add(new Pet(1, String.valueOf(random.nextLong()), names[random.nextInt(names.length)], specie[random.nextInt(specie.length)], "pet_race",
                        size[random.nextInt(size.length)], sex[random.nextInt(sex.length)], "null", ownerId ));
            }
        }
        return Response.ok()
                .entity(pets)
                .build();
    }

}
