/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OFC_Server2.java.event;

import OFC_Server2.java.exceptions.*;
import java.util.Date;
import java.util.Set;
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
 * @author 2dam
 */

@Path("event")
public class EventFacadeREST {

    @EJB
    private EventManager ejb; 

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Event entity) {
        try {
            ejb.createEvent(entity);
        } catch (CreateException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
        
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Event entity) {
        try {
           ejb.updateEvent(entity); 
        } catch (UpdateException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
        
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        try {
            ejb.deleteEvent(id);
        } catch (DeleteException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Event> findAllEvents() {
        Set<Event> events;
        try {
            events = ejb.findEvents(); 
        } catch (ReadException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
       return events;
    }
    
    @GET
    @Path("findEventByName/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Event findEventByName(@PathParam("name") String name) {
        Event ev;
        try {
            ev = ejb.findEventByName(name);
        } catch (ReadException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
        return ev;
    }
    
    @GET
    @Path("findEventByActivity/{activity}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Event> findEventByActivity(@PathParam("activity")String activity) {
        Set<Event> events;
        try {
            events = ejb.findEventByActivity(activity);
        } catch (ReadException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
        return events;
    }
    /*
    @GET
    @Path("findEventByUser/{user}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Event> findEventByUser(Event event) {
        return ejb.findEventByUser(event);
    }*/
    
    @GET
    @Path("findEventByDate/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Event> findEventByDate(@PathParam("date") Date date) {
        Set<Event> events;
        try {
            events = ejb.findEventByDate(date);
        } catch (ReadException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
        return events;
    }
    
}
