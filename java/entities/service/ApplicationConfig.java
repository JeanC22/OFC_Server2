/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * This is the User management RESTful web service application class.
 * @author Javier Martín Uría
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {
    /**
     * Gets classes for web service application resources.  
     * @return A Set containing Class objects for resources.
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    /**
     * Adds needed resource's classes to a Set of resources.
     * @param resources The resource's classes Set.
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
     
        resources.add(comments.ComentFacadeREST.class);
        resources.add(event.EventFacadeREST.class);
        resources.add(routine.ExerciseFacadeREST.class);
        resources.add(routine.RoutineFacadeREST.class);
        resources.add(sponsors.SponsorFacadeREST.class);
        resources.add(usuario.AdminFacadeREST.class);
        resources.add(usuario.ClientFacadeREST.class);
        resources.add(usuario.UserFacadeREST.class);
        
    }
   
    
}