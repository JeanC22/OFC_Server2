/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import comments.Coment;
import entities.service.AbstractFacade;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * @author 2dam
 */
@Stateless
@Path("comments.coment")
public class ComentFacadeREST {

    @PersistenceContext(unitName = "OFC_ServerWebPU")
    @EJB
    private EJBComentManager ejb;
    private Set<Coment> coments = new HashSet<>();

    public ComentFacadeREST() {

    }
//crear

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Coment coment) {
        try {
            ejb.createComent(coment);
        } catch (Exception e) {
        }
    }
//edit

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Coment coment) {
        try {
            ejb.editComent(coment);
        } catch (Exception e) {
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        try {
            ejb.deleteComent(id);
        } catch (Exception e) {
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findAllComents() {
        try {
            coments = ejb.getAllComents();
        } catch (Exception e) {
        }
        return coments;
    }

    @GET
    @Path("{subject}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> find(@PathParam("subject") String subject) {
        try {
            coments = ejb.findBySubject(subject);
        } catch (Exception e) {
        }
        return coments;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findOrderByMoreRecent() {
        try {
            ejb.findOrderByMoreRecent();
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findOrderByLastPublicate(@PathParam("id") Long id) {
        try {
            coments = ejb.findOrderByLastPublicate();
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findOrderByMoreRate() {
        try {
            coments = ejb.findOrderByMoreRate();
        } catch (Exception e) {
        }
        return coments;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findOrderByLessRate() {
        try {
            coments = ejb.findOrderByLessRate();
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyComments(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyComments(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyComentOrderByMoreRecent(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyComentOrderByMoreRecent(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> find(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyComentOrderBylastPublication(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyComentOrderByMoreRate(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyComentOrderByMoreRate(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyComentOrderByLessRate(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyComentOrderByLessRate(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyPrivateComents(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyPrivateComents(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyPublicComents(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyPublicComents(id);
        } catch (Exception e) {
        }
        return coments;

    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Coment> findMyCommentByEvent(@PathParam("id") Long id) {
        try {
            coments = ejb.findMyCommentByEvent(id);
        } catch (Exception e) {
        }
        return coments;

    }

}
