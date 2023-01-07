/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import event.Event;
import event.EventManager;
import exceptions.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This is the class that will maintain the communication with the client 
 * side of our application.
 * @author iker
 */
@Path("event")
public class EventFacadeREST {

    @EJB
    private EventManager ejb; 
    /**
     * This method will call the createEvent method of the interface to create 
     * an event in the database and in case of receiving an error we will send
     * an internal server error.
     * @param entity is the parameter that we send to put it in the DB.
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Event entity) {
        try {
            ejb.createEvent(entity);
        } catch (CreateException e) {
            System.out.println(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
        
    }

    /**
     * This method is used to edit the data in a database and in case the data 
     * does not exist to create it and in case of receiving an error we will
     * send an internal server error.
     * @param entity is the parameter we send to edit data in the DB.
     */
    
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Event entity) {
        try {
           ejb.updateEvent(entity); 
        } catch (UpdateException e) {
            System.out.println(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
        
    }

    /**
     * This method is used to remove data from the database and in case of 
     * receiving an error we will send an internal server error
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        try {
            ejb.deleteEvent(ejb.findEventById(id));
        } catch (DeleteException | ReadException e) {
            System.out.println(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
        
    }
    
    /**
     * This method allows us to query the database to return a list of 
     * database events and in case of receiving an error we will send an 
     * internal server error.
     * @return events is a list of the result of the query.
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Event> findAllEvents() {
        List<Event> events;
        try {
            events = ejb.findEvents(); 
        } catch (ReadException e) {
            System.out.println(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
       return events;
    }
    /**
     * This method allows us to make a query according to the id of an event 
     * and in case of receiving an error we will send an internal server error.
     * @param id is the parameter sent to make the search
     * @return ev is the value returned
     */
    @GET
    @Path("findEventById/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Event findEventByName(@PathParam("id") Long id) {
        Event ev;
        try {
            ev = ejb.findEventById(id);
            if(ev == null){
                throw new NotFoundException();
            }
        } catch (ReadException e) {
            System.out.println(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
        return ev;
    }
    
    /**
     * This method is to make a query for the name of an event and in case of 
     * receiving an error we will send an internal server error.
     * @param name is what we will send to conduct the search
     * @return ev is the result of the consultation
     */
    @GET
    @Path("findEventByName/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Event findEventByName(@PathParam("name") String name) {
        Event ev;
        try {
            ev = ejb.findEventByName(name);
            if(ev == null){
                throw new NotFoundException();
            }
        } catch (ReadException e) {
            System.out.println(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
        return ev;
    }
    
    /**
     * This method allows us to perform a query for the type of activity of 
     * an event and in case of receiving an error we will send an internal 
     * server error.
     * @param activity is the parameter sent to make the query
     * @return events is a list of events detected in the query
     */
    @GET
    @Path("findEventByActivity/{activity}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Event> findEventByActivity(@PathParam("activity")String activity) {
        List<Event> events;
        try {
            events = ejb.findEventByActivity(activity);
            if(events.isEmpty()){
                throw new NotFoundException();
            }
        } catch (ReadException e) {
            System.out.println(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
        return events;
    }
    
    /**
     * This method allows us to search for events by date and in case of 
     * receiving an error we will send an internal server error.
     * @param date is the data sent for the search
     * @return events is the list returned from the query
     */
    @GET
    @Path("findEventByDate/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Event> findEventByDate(@PathParam("date") Date date) {
        List<Event> events;
        try {
            events = ejb.findEventByDate(date);
            if(events.isEmpty()){
                throw new NotFoundException();
            }
        } catch (ReadException e) {
            System.out.println(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
        return events;
    }
    
}
