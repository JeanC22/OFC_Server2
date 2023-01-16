/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sponsors;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import javax.ws.rs.InternalServerErrorException;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Restful service for Sponsor
 * @author Elias
 */
@Path("sponsor")
public class SponsorFacadeREST {
    private static final Logger LOGGER = Logger.getLogger("sponsors.SponsorFacadeREST");
    /**
     * EJB object
     */
    @EJB
    private SponsorManager ejb;
    
     /**
     * POST method to create Sponsor in our database
     * @param entity The Sponsor object
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Sponsor entity) {
        try {
            LOGGER.info("Create Sponsor");
            ejb.createSponsor(entity);
        } catch (CreateException c) {
            LOGGER.severe(c.getMessage());
            throw new InternalServerErrorException(c.getMessage());
        }
            
    }
    /**
     * PUT method to modify Sponsor in our database
     * @param entity The Sponsor object
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Sponsor entity) {
        try {
           LOGGER.info("Update Sponsor");
           ejb.updateSponsor(entity); 
        } catch (UpdateException u) {
            LOGGER.severe(u.getMessage());
            throw new InternalServerErrorException(u.getMessage());
        }
          
        
    }
    /**
     * DELETE method to remove Sponsor in our database
     * @param id ID Sponsor
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        try {
            LOGGER.info("Remove Sponsor");
           ejb.removeSponsor(ejb.findSponsor(id)); 
        } catch (DeleteException | ReadException d) {
            LOGGER.severe(d.getMessage());
            throw new InternalServerErrorException(d.getMessage());
        }
        
    }
    /**
     * GET method to get all Sponsors in our database
     * @return List of Sponsor
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sponsor> findAllSponsors() {
        List<Sponsor> sponsors;
        try {
            LOGGER.info("Reading all sponsors");
           sponsors = ejb.findAllSponsor();
        } catch (ReadException r) {
            LOGGER.severe(r.getMessage());
            throw new InternalServerErrorException(r.getMessage());
        }
        return sponsors;
    }
    
    
    /**
     * GET method to get Sponsors by Name in our database
     * @param name Sponsor name
     * @return List of Sponsor
     */
    @GET
    @Path("findSponsorByName/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sponsor findSponsorByName(@PathParam("name") String name) {
        Sponsor sponsor;
        try {
            LOGGER.info("Reading sponsor by name");
           sponsor = ejb.findSponsorByName(name);
           if(sponsor == null){
               throw new NotFoundException();
           }
        } catch (ReadException r) {
            LOGGER.severe(r.getMessage());
            throw new InternalServerErrorException(r.getMessage());
        }
        return sponsor;
    }
    /**
     * GET method to get Sponsors by Date in our database
     * @param strdate Date for Sponsor in String
     * @return List od Sponsor
     */
    @GET
    @Path("findSponsorByDate/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sponsor> findSponsorByDate(@PathParam("date") String strdate) {
        List<Sponsor> sponsors = null;
        
        try {
            LOGGER.info("Reading Sponsor by date");
           sponsors=ejb.findSponsorByDate(strdate); 
        } catch (ReadException r) {
            LOGGER.severe(r.getMessage());
            throw new InternalServerErrorException(r.getMessage());
        }
        return sponsors;
    }
    /**
     * GET method to get Sponsor by ID in our database
     * @param id id for Sponsor
     * @return Sponsor object
     */
    @GET
    @Path("findSponsor/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sponsor find(@PathParam("id") Long id) {
        Sponsor sponsor;
        try {
            LOGGER.info("Reading sponsor by date");
           sponsor = ejb.findSponsor(id);
           if(sponsor == null){
               throw new NotFoundException();
           }
        } catch (ReadException r) {
            LOGGER.severe(r.getMessage());
            throw new InternalServerErrorException(r.getMessage());
        }
        return sponsor;
    }
}
