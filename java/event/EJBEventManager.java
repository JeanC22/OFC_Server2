/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;


import usuario.User;
import exceptions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class is in charge of managing the CRUD of events.
 *
 * @author iker
 */
@Stateless
public class EJBEventManager implements EventManager {

    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;

    /**
     * This method will create an event in the database.
     *
     * @param event we will send it to insert an event in the DB
     * @throws CreateException we will use it to control possible errors
     */
    @Override
    public void createEvent(Event event) throws CreateException {
        User u;
        try {
            em.persist(event);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    /**
     * The method will modify or create if a DB event does not exist.
     *
     * @param event this will be the parameter that we want to insert or modify
     * in the DB
     * @throws UpdateException we will use it to control possible errors
     */
    @Override
    public void updateEvent(Event event) throws UpdateException {
        try {
            if (!em.contains(event)) {
                em.merge(event);
                em.flush();
            }
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }

    }

    /**
     * The method is in charge of deleting from the DB the event that we send it
     *
     * @param event is the parameter we will send to delete it from the DB.
     * @throws DeleteException we will use it to control possible errors
     */
    @Override
    public void deleteEvent(Event event) throws DeleteException {
        try {
            em.remove(em.merge(event));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }

    }

    /**
     * The method performs a query of all the events in our database.
     *
     * @return events returns a list of all events found in the database.
     * @throws ReadException we will use it to control possible errors
     */
    @Override
    public List<Event> findEvents() throws ReadException {
        List<Event> events;
        try {
            events = em.createNamedQuery("findEvents").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return events;
    }

    /**
     * This method performs a search for an event by its id in the DB.
     *
     * @param id is the parameter we send to perform the search
     * @return event is the object that returns the query
     * @throws ReadException we will use it to control possible errors
     */
    @Override
    public Event findEventById(Long id) throws ReadException {
        Event event;
        try {
            event = em.find(Event.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return event;
    }

    /**
     * This method performs a search for an event by its name in the DB.
     *
     * @param name is the parameter we send to perform the search
     * @return ev is the object that returns the query
     * @throws ReadException we will use it to control possible errors
     */
    @Override
    public Event findEventByName(String name) throws ReadException {
        Event ev;
        List<Event> events;
        try {
            events = em.createNamedQuery("findEventByName").setParameter("name", name).getResultList();
            ev = events.get(0);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return ev;
    }

    /**
     * This method performs a search for an event by its activity in the DB.
     *
     * @param activity is the parameter we send to perform the search
     * @return events is a list of events found with the same activity.
     * @throws ReadException we will use it to control possible errors
     */
    @Override
    public List<Event> findEventByActivity(String activity) throws ReadException {
        List<Event> events;
        try {
            events = em.createNamedQuery("findEventByActivity").setParameter("activity", activity + "%").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return events;

    }

    /**
     * This method performs a search for an event by its date in the DB
     *
     * @param date is the parameter we send to perform the search
     * @return events is a list of events found with the same date.
     * @throws ReadException we will use it to control possible errors
     */
    @Override
    public List<Event> findEventByDate(String date) throws ReadException {
         List<Event> events = null;
            try {
               
                Date dateformat= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").parse(date);
                try {
                    
                    events = em.createNamedQuery("findEventByDate").setParameter("date", dateformat).getResultList();
                } catch (Exception e) {
                    throw new ReadException(e.getMessage());
                }
                
               
                
            } catch (ParseException ex) {
            Logger.getLogger(EJBEventManager.class.getName()).log(Level.SEVERE, null, ex);
            }
         return events;
        
        }
    }

