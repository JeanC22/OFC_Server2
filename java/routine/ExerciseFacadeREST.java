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
@Path("exercise")
public class ExerciseFacadeREST {

    private static final Logger LOGGER = Logger.getLogger("routine.ExerciseFacadeREST");

    
        
    @EJB
    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private ExerciseManager ejb;


    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Exercise exercise) {
       try {
           ejb.addExercise(exercise);
        } catch (CreateException e) {
          throw new InternalServerErrorException(e.getMessage());
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Exercise exercise) {
        try {
           ejb.updateExercise(exercise);
        } catch (UpdateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Exercise exercise) {
       try {
           ejb.deleteExercise(exercise);
        } catch (DeleteException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());

        }
    }

    @GET
    @Path("consultExerciseById/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Exercise consultExerciseById(@PathParam("id") Long id) {
        Exercise exercise=null;
        try {
            exercise= ejb.consultExerciseById(id);
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
    }
        return exercise;
    }

    @GET
    @Path("consultAllExercises/")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Exercise> consultAllExercises() {
        List<Exercise> exercise=null;
        try {
            exercise= (List<Exercise>) ejb.consultAllExercises();
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
    }
        return exercise;
    }

    @GET
    @Path("consultExerciseByName/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Exercise> consultExerciseByName(@PathParam("name") String name) {
       List<Exercise> exercise=null;
        try {
            exercise= (List<Exercise>) ejb.consultExerciseByName(name);
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
    }
        return exercise;
    }

    
}
