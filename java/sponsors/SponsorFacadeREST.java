/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sponsors;

import java.util.Date;
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
        } catch (Exception e) {
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
        } catch (Exception e) {
        }
          
        
    }
    /**
     * DELETE method to remove Sponsor
     * @param name The name for Sponsor
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String name) {
        try {
           ejb.removeSponsor(ejb.findSponsorByName(name)); 
        } catch (Exception e) {
        }
        
    }
    /**
     * GET method to get Sponsor by name
     * @param id id for Sponsor
     * @return Sponsor object
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sponsor find(@PathParam("id") Long id) {
        Sponsor sponsor = null;
        try {
           sponsor = ejb.findSponsor(id);
        } catch (Exception e) {
        }
        return sponsor;
    }
    /**
     * GET method to get all Sponsors 
     * @return List of Sponsor
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Sponsor> findAll() {
        Set<Sponsor> sponsors = null;
        sponsors = ejb.findAllSponsor();
        return sponsors;
    }
    /**
     * GET method to get Sponsors by Date
     * @param date The date for Sponsor
     * @return List od Sponsor
     */
    @GET
    @Path("findSponsorByDate/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Sponsor> findRange(@PathParam("date") Date date) {
        Set<Sponsor> sponsors = null;
        try {
           sponsors=ejb.findSponsorByDate(date); 
        } catch (Exception e) {
        }
        return sponsors;
    }
}
