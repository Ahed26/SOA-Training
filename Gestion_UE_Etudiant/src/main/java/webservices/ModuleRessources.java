package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UERessources1 {
    package webservices;

import metiers.UniteEnseignementBusiness;
import entities.UniteEnseignement;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.util.List;


    @Path("/ue")
    public class UERessources {

        static UniteEnseignementBusiness helper = new UniteEnseignementBusiness();
        //GETALL UES
        @GET
        @Path("/liste")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getALLUe() {
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
        @Produces(MediaType.TEXT_PLAIN)
        public Response addUE(UniteEnseignement ue) {
            if (helper.addUniteEnseignement(ue)) {
                return Response.status(201).entity("added successfully").build();


            } else {
                return Response.status(409).entity("already exist").build();
            }

        }
        //delete
        @DELETE
        @Path("/delete/{id}")
        @Produces(MediaType.TEXT_PLAIN)
        public Response deleteUE(@PathParam("id") int id) {
            if (helper.deleteUniteEnseignement(id)) {
                return Response.status(200).entity("deleted successfully").build();
            } else {
                return Response.status(404).entity("UE not found").build();
            }
        }
        //search by code
        @Path("/search")
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response search(@QueryParam(value="s")int semestre) {
            return Response.status(200).entity(this.helper.getUEBySemestre(semestre)).build();
        }
    }


}
