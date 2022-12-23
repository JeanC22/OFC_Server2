/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import comments.Coment;
import java.util.HashSet;
import java.util.Set;
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

@Path("entities.coment")
public class ComentFacadeREST {

    @EJB
    private comments.CommentsMannager ejb;
        
    private Set<Coment> coments = null;
//crear

    @POST
    @Path("createComent/{coment}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createComent(@PathParam("coment") Coment coment) {
        try {
            ejb.createComent(coment);
        } catch (Exception e) {
        }
    }
//edit

    @PUT
    @Path("editComent/{coment}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editComent(@PathParam("coment") Coment coment) {
        try {
            ejb.editComent(coment);
        } catch (Exception e) {
        }
    }

    @DELETE
    @Path("deleteComent/{id}")
    public void deleteComent(@PathParam("id") Long id) {
        try {
            ejb.deleteComent(id);
        } catch (Exception e) {
        }
    }

    @GET
    @Path("findAllComents")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findAllComents() {
        try {
            coments = ejb.getAllComents();
        } catch (Exception e) {
        }
        return coments;
    }

    @GET
    @Path("findBySubject/{subject}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> find(@PathParam("subject") String subject) {
        try {
            coments = ejb.findBySubject(subject);
        } catch (Exception e) {
        }
        return coments;
    }

    @GET
    @Path("findOrderByMoreRecent")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findOrderByMoreRecent() {
        try {
            ejb.findOrderByMoreRecent();
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findOrderByLastPublicate/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findOrderByLastPublicate(@PathParam("id") Long id) {
        try {
            coments = ejb.findOrderByLastPublicate();
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findOrderByMoreRate")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findOrderByMoreRate() {
        try {
            coments = ejb.findOrderByMoreRate();
        } catch (Exception e) {
        }
        return coments;
    }

    @GET
    @Path("findOrderByLessRate")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findOrderByLessRate() {
        try {
            coments = ejb.findOrderByLessRate();
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findMyComments/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyComments(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyComments(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findMyComentOrderByMoreRecent/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyComentOrderByMoreRecent(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyComentOrderByMoreRecent(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findMyComentOrderBylastPublication/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> find(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyComentOrderBylastPublication(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findMyComentOrderByMoreRate/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyComentOrderByMoreRate(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyComentOrderByMoreRate(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findMyComentOrderByLessRate/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyComentOrderByLessRate(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyComentOrderByLessRate(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findMyPrivateComents/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyPrivateComents(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyPrivateComents(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findMyPublicComents/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyPublicComents(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyPublicComents(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("findMyCommentByEvent/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyCommentByEvent(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyCommentByEvent(id);
        } catch (Exception e) {
        }
        return coments;

    }

}
