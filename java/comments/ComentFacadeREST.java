/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import entities.Client;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jeanpierr Caraballo
 */
@Path("comments")
public class ComentFacadeREST {

    @EJB
    private comments.CommentsMannager ejb;

//crear
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createComent(Coment coment) {
        try {
            ejb.createComent(coment);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
//edit

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editComent(Coment coment) {
        try {
            ejb.editComent(coment);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    @DELETE
    @Path("deleteComent/{clientID}/{evetID}")
    public void deleteComent(@PathParam("clientID") Long clientID, @PathParam("evetID")Long evetID ){
            
        try {
            ejb.deleteComent(clientID,evetID);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> findAllComents() {
        List<Coment> coments = null;
        try {
            coments = ejb.getAllComents();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return coments;
    }

    @GET
    @Path("findBySubject/{subject}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> find(@PathParam("subject") String subject) {
        List<Coment> coments = null;

        try {
            coments = ejb.findBySubject(subject);
        } catch (Exception e) {
        }
        return coments;
    }

    @GET
    @Path("findOrderByMoreRecent")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> findOrderByMoreRecent() {
        List<Coment> coments = null;
        try {
          coments = ejb.findOrderByMoreRecent();
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findOrderByLastPublicate")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> findOrderByLastPublicate() {
        List<Coment> coments = null;
        try {
            coments = ejb.findOrderByLastPublicate();
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findOrderByMoreRate")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> findOrderByMoreRate() {
        List<Coment> coments = null;
        try {
            coments = ejb.findOrderByMoreRate();
        } catch (Exception e) {
        }
        return coments;
    }

    @GET
    @Path("findOrderByLessRate")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> findOrderByLessRate() {
        List<Coment> coments = null;
        try {
            coments = ejb.findOrderByLessRate();
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findMyComments/{clientID}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> findMyComments(@PathParam("clientID") Long clientID) {
        List<Coment> coments = null;
        try {
            coments = ejb.findMyComments(clientID);
        } catch (Exception e) {
        }
        return coments;

    }
}
