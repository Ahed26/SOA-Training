package webservices;

import metiers.UniteEnseignementBusiness;
import entities.UniteEnseignement; // ton entité à vérifier

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/ue")
public class UERessources {

    UniteEnseignementBusiness helper = new UniteEnseignementBusiness();

    @GET
    @Path("/liste")
    @Produces(MediaType.APPLICATION_JSON)
    public Response liste() {
       return Response.status(200).entity(
               helper.getListeUE()
       ).build();
    }


    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        return Response.status(Response.Status.OK)
                .entity("hello 4infini")
                .build();
    }

    //ADD
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUE(UniteEnseignement ue) {
        if (helper.addUniteEnseignement(ue)) {
            return Response.status(201).entity("added successfully").build();


        } else {
            return Response.status(500).entity("already exist").build();
        }
    } @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUE(@PathParam("id") int id) {
        if (helper.deleteUniteEnseignement(id)) {
            return Response.status(200).entity("deleted successfully").build();
        } else {
            return Response.status(404).entity("UE not found").build();
        }
    }}
