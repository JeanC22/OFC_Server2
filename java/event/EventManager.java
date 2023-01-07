/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;


import exceptions.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * This class is the interface to the EJBEventManager methods.
 * @author iker
 */

public interface EventManager {
    
    public void createEvent(Event event) throws CreateException;
    
    public void updateEvent(Event event) throws UpdateException;
    
    public void deleteEvent(Event event)throws DeleteException;
    
    public List<Event> findEvents() throws ReadException;
    
    public Event findEventById(Long id) throws ReadException;
    
    public Event findEventByName(String name) throws ReadException;
    
    public List<Event> findEventByActivity(String activity) throws ReadException;
    
    public List<Event> findEventByDate(Date date) throws ReadException;
}
