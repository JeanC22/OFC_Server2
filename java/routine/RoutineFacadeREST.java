/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.routine;


import java.exceptions.CreateException;
import java.exceptions.DeleteException;
import java.exceptions.ReadException;
import java.exceptions.UpdateException;
import java.util.List;

import java.util.Set;
import java.util.logging.Logger;
import javax.ejb.EJB;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * @author Aritz
 */
@Path("routine")
public class RoutineFacadeREST {
    
    private static final Logger LOGGER = Logger.getLogger("routine.RoutineFacadeREST");

    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;

    
    @EJB
    private RoutineManager ejb;
    

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Routine routine){
        try {
           ejb.addRoutine(routine);
        } catch (CreateException e) {
            LOGGER.severe(e.getMessage());
           throw new InternalServerErrorException(e.getMessage());
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Routine routine) {
     try {
           ejb.updateRoutine(routine);
        } catch (UpdateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @DELETE
    @Path("{routine}")
    public void remove(@PathParam("routine") Routine routine) {
        try {
           ejb.deleteRoutine(routine);
        } catch (DeleteException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());

        }
    }

    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Routine> consultRoutinesByName(@PathParam("name") String name) {
        List<Routine> routine=null;
         try {
           routine= ejb.consultRoutineByName(name);
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
           throw new InternalServerErrorException(e.getMessage());
        }
         return routine;
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Routine> consultAllClientRoutines(@PathParam("id") Integer id) {
        List<Routine> routine=null;
        try {
            routine= ejb.consultAllRoutines(id);
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
    }
        return routine;
    }

    @GET
    @Path("exercise/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Set<Routine> consultRoutineByExercise(@PathParam("id") Integer id) {

        Set<Routine> routines= null;
        try {
            
           routines= ejb.consultRoutineByExercise(id);
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
        return routines;
    }

    
    
}
