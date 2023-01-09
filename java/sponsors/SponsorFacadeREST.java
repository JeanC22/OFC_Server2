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
import java.util.Date;
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
 * Restful service for Sponsor
 * @author Elias
 */
@Path("sponsors.sponsor")
public class SponsorFacadeREST {
    /**
     * EJB object
     */
    @EJB
    private SponsorManager ejb;
    
     /**
     * POST method to create Sponsor
     * @param entity The Sponsor object
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Sponsor entity) {
        try {
            ejb.createSponsor(entity);
        } catch (CreateException c) {
            throw new InternalServerErrorException(c.getMessage());
        }
            
    }
    /**
     * PUT method to modify Sponsor
     * @param entity The Sponsor object
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Sponsor entity) {
        try {
           ejb.updateSponsor(entity); 
        } catch (UpdateException u) {
            throw new InternalServerErrorException(u.getMessage());
        }
          
        
    }
    /**
     * DELETE method to remove Sponsor
     * @param id ID Sponsor
     * @throws exceptions.ReadException
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) throws ReadException {
        try {
           ejb.removeSponsor(ejb.findSponsor(id)); 
        } catch (DeleteException d) {
            throw new InternalServerErrorException(d.getMessage());
        }
        
    }
    /**
     * GET method to get Sponsor by ID
     * @param id id for Sponsor
     * @return Sponsor object
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sponsor find(@PathParam("id") Long id) {
        try {
           return ejb.findSponsor(id);
        } catch (ReadException r) {
            throw new InternalServerErrorException(r.getMessage());
        }

    }
    /**
     * GET method to get all Sponsors 
     * @return List of Sponsor
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sponsor> findAll() {
        List<Sponsor> sponsors = null;
        try {
           sponsors = ejb.findAllSponsor(); 
        } catch (ReadException r) {
            throw new InternalServerErrorException(r.getMessage());
        }
        
        return sponsors;
    }
    /**
     * GET method to get Sponsors by Name
     * @param name Sponsor name
     * @return List of Sponsor
     */
    @GET
    @Path("findSponsorByName/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sponsor findSponsorByName(@PathParam("name") String name) {
        try {
           return ejb.findSponsorByName(name);
        } catch (ReadException r) {
            throw new InternalServerErrorException(r.getMessage());
        }
        
    }
    /**
     * GET method to get Sponsors by Date
     * @param date The date for Sponsor
     * @return List od Sponsor
     */
    @GET
    @Path("findSponsorByDate/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sponsor> findRange(@PathParam("date") Date date) {
        List<Sponsor> sponsors = null;
        try {
           sponsors=ejb.findSponsorByDate(date); 
        } catch (ReadException r) {
            throw new InternalServerErrorException(r.getMessage());
        }
        return sponsors;
    }
}
