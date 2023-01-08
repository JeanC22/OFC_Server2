/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routine;


import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.util.List;

import java.util.Set;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
    
    @EJB
    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private RoutineManager ejb;
    

    /**
     * This method will call the addRoutine method of the interface to create 
     * an event in the database and in case of receiving an error we will send
     * an internal server error.
     * @param routine the new routine
     */
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

    /**
     * This method is used to edit the data in a database and in case the data 
     * does not exist to create it and in case of receiving an error we will
     * send an internal server error.
     * @param routine updated routine
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Routine routine) {
        try {
           ejb.updateRoutine(routine);
        } catch (UpdateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }
    /**
     * This method is used to remove data from the database and in case of 
     * receiving an error we will send an internal server error
     * @param routine the routine that will be deleted
     */
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

    /**
     * This method looks for the routine that has a specific name
     * @param name the routine name
     * @return Returns a routine
     */
    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Routine consultRoutinesByName(@PathParam("name") String name) {
        Routine routine;
         try {
           routine= ejb.consultRoutineByName(name);
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
           throw new InternalServerErrorException(e.getMessage());
        }
         return routine;
    }

    /**
     * This method searches all the routines of a client.
     * @param id Client id
     * @return Returns a list of routines
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Routine> consultAllClientRoutines(@PathParam("id") Integer id) {
        List<Routine> routine=null;
        try {
            routine= ejb.consultAllClientRoutines(id);
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
    }
        return routine;
    }

    /**
     * This method searches for all routines in which there is a specific 
     * exercise.
     * @param id the exercise id
     * @return Returns a list of routines
     */
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
