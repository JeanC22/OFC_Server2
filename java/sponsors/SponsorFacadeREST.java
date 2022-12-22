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


//select e from event e where e.id in(select ec.events_id from event_client where clients_id = )
/**
 * Restful service for Sponsor
 * @author Elias
 */
@Path("sponsor")
public class SponsorFacadeREST {
    /**
     * EJB object
     */
    @EJB
    private EJBSponsorManager ejb;
    
    /**
     * POST method to create Sponsor
     * @param entity The Sponsor object
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Sponsor entity) {
        ejb.createSponsor(entity);
    }
    /**
     * PUT method to modify Sponsor
     * @param entity The Sponsor object
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Sponsor entity) {
        ejb.updateSponsor(entity);
    }
    /**
     * DELETE method to remove Sponsor
     * @param name The name for Sponsor
     */
    @DELETE
    @Path("{name}")
    public void remove(@PathParam("name") String name) {
        ejb.removeSponsor(ejb.findSponsorByName(name));
    }
    /**
     * GET method to get Sponsor by name
     * @param name The name for Sponsor
     * @return Sponsor object
     */
    @GET
    @Path("findSponsorByName/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sponsor find(@PathParam("name") String name) {
        return ejb.findSponsorByName(name);
    }
    /**
     * GET method to get all Sponsors 
     * @return List of Sponsor
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Sponsor> findAll() {
        return ejb.findAllSponsor();
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
        return ejb.findSponsorByDate(date);
    }
}
