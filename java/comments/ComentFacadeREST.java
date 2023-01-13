/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
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

    /**
     * EJB object implementing business logic.
     */
    @EJB
    private CommentsMannager ejb;
    /**
     * Logger for this class.
     */
    private Logger LOGGER = Logger.getLogger(ComentFacadeREST.class.getName());

    /**
     * POST method to create customers: uses createCustomer business logic
     * method.
     *
     * @param coment The Coment entity object containing new coment data.
     * @throws exceptions.ReadException
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createComent(Coment coment) throws ReadException {
        try {
            ejb.createComent(coment);
        } catch (CreateException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    /**
     * PUT method to modify coment: uses updateCustomer business logic method.
     *
     * @param coment The coment object containing data
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editComent(Coment coment) {
        try {
            LOGGER.log(Level.INFO, "Updating coment {0}", coment.getComentid());
            ejb.editComent(coment);
        } catch (UpdateException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    /**
     * DELETE method to remove customers: uses removeCustomer business logic
     * method.
     *
     * @param clientID the id for the coment to be deleted.
     * @param evetID the id for the coment to be deleted.
     */
    @DELETE
    @Path("deleteComent/{clientID}/{evetID}")
    public void deleteComent(@PathParam("clientID") Long clientID, @PathParam("evetID") Long evetID) {

        try {
            LOGGER.log(Level.INFO, "Deleting coment {0}", " clientID: " + clientID + " eventID: " + evetID);

            ejb.deleteComent(clientID, evetID);
        } catch (DeleteException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }

    }

    /**
     * GET method for getting all coments it uses the business method
     * findCustomer.
     *
     * @return A list of coment object.
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> findAllComents() {
        List<Coment> coments;
        try {
            LOGGER.log(Level.INFO, "Reading data for all coments.");
            coments = ejb.getAllComents();
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
        return coments;
    }

    /**
     * GET method for getting all coments by its subject: it uses the business
     * method findBySubject.
     *
     * @param subject
     * @return A list of coment object.
     */
    @GET
    @Path("findBySubject/{subject}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> find(@PathParam("subject") String subject) {
        List<Coment> coments = null;

        try {
            LOGGER.log(Level.INFO, "Reading data for all coments.");
            coments = ejb.findBySubject(subject);
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
        return coments;
    }

    /**
     * GET method for getting all coments by more recent it uses the business
     * method findOrderByMoreRecent.
     *
     * @return A list of coment object.
     */
    @GET
    @Path("findOrderByMoreRecent")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> findOrderByMoreRecent() {
        List<Coment> coments = null;
        try {
            LOGGER.log(Level.INFO, "Reading data for all coments.");
            coments = ejb.findOrderByMoreRecent();
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
        return coments;

    }

    /**
     * GET method for getting all coments by last publicate it uses the business
     * method findOrderByLastPublicate.
     *
     * @return A list of coment object.
     */
    @GET
    @Path("findOrderByLastPublicate")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> findOrderByLastPublicate() {
        List<Coment> coments = null;
        try {
            LOGGER.log(Level.INFO, "Reading data for all coments.");
            coments = ejb.findOrderByLastPublicate();
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
        return coments;

    }

    /**
     * GET method for getting all coments by more rate it uses the business
     * method findOrderByMoreRate.
     *
     * @return A list of coment object.
     */
    @GET
    @Path("findOrderByMoreRate")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> findOrderByMoreRate() {
        List<Coment> coments = null;
        try {
            LOGGER.log(Level.INFO, "Reading data for all coments.");
            coments = ejb.findOrderByMoreRate();
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
        return coments;
    }

    /**
     * GET method for getting all coments by less rate it uses the business
     * method findOrderByLessRate.
     *
     * @return A list of coment object.
     */
    @GET
    @Path("findOrderByLessRate")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> findOrderByLessRate() {
        List<Coment> coments = null;
        try {
            LOGGER.log(Level.INFO, "Reading data for all coments.");
            coments = ejb.findOrderByLessRate();
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
        return coments;

    }

    /**
     * GET method for getting all coments from client it uses the business
     * method findMyComments.
     *
     * @param clientID the clientID
     * @return A list of coment object.
     */
    @GET
    @Path("findMyComments/{clientID}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Coment> findMyComments(@PathParam("clientID") Long clientID) {
        List<Coment> coments = null;
        try {
            LOGGER.log(Level.INFO, "Reading data for all coments.");
            coments = ejb.findMyComments(clientID);
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
        return coments;

    }
}
