/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OFC_Server2.java.event;

import OFC_Server2.java.entities.User;
import OFC_Server2.java.exceptions.*;
import java.util.Date;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 2dam
 */
@Stateless
public class EJBEventManager implements EventManager{

    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;
    
    @Override
    public void createEvent(Event event) throws CreateException{
        User u;
        try{
          em.persist(event);
        }catch(Exception e){
            throw new CreateException(e.getMessage());
        }
    }

    /**
     *
     * @param event
     * @throws UpdateException
     */
    @Override
    public void updateEvent(Event event) throws UpdateException{
        try{
            em.merge(event);
        }catch(Exception e){
            throw new UpdateException(e.getMessage());
        }
        
    }

    @Override
    public void deleteEvent(Long id) throws DeleteException{
        try{
            em.remove(id);
        }catch(Exception e){
            throw new DeleteException(e.getMessage());
        }
        
    }

    @Override
    public Set<Event> findEvents() throws ReadException{
        Set<Event> events;
        try {
            events = (Set<Event>) em.createNamedQuery("findEvents").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        
        return events;
    }

    @Override
    public Event findEventByName(String name) throws ReadException{
        Event ev;
        try {
           ev = em.find(Event.class,name);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
       
        return ev;
    }

    @Override
    public Set<Event> findEventByActivity(String activity) throws ReadException{
        Set<Event> events;
        try {
             events =  (Set<Event>) em.createNamedQuery("findEventByActivity").setParameter("activity", activity).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
       
        return events;
        
    }

    @Override
    public Set<Event> findEventByDate(Date date) throws ReadException{
        Set<Event> events;
        try {
            events = (Set<Event>) em.createNamedQuery("findEventByDate").setParameter("date",date).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        
        return events;
    }
/*
    @Override
    public Set<Event> findEventByUser(Event event) {
        Set<Event> events = null;
        
        return events;
    }
  */  

}
