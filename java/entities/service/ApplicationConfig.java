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
     
        resources.add(entities.service.AdminFacadeREST.class);
        resources.add(entities.service.ClientFacadeREST.class);
        resources.add(entities.service.ComentFacadeREST.class);
        resources.add(entities.service.EventFacadeREST.class);
        resources.add(entities.service.ExerciseFacadeREST.class);
        resources.add(entities.service.RoutineFacadeREST.class);
        resources.add(entities.service.SponsorFacadeREST.class);
        resources.add(entities.service.UserFacadeREST.class);
    }
   
    
}