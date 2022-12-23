/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OFC_Server2.java.event;


import OFC_Server2.java.exceptions.*;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author 2dam
 */

public interface EventManager {
    
    public void createEvent(Event event) throws CreateException;
    
    public void updateEvent(Event event) throws UpdateException;
    
    public void deleteEvent(Long id)throws DeleteException;
    
    public Set<Event> findEvents() throws ReadException;
    
    public Event findEventByName(String name) throws ReadException;
    
    public Set<Event> findEventByActivity(String activity) throws ReadException;
    
    public Set<Event> findEventByDate(Date date) throws ReadException;
    
    //public Set<Event> findEventByUser(Event event);
}
