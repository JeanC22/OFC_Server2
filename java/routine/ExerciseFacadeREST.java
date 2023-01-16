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
import java.util.logging.Level;
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
    //@PersistenceContext(unitName = "OFC_ServerWebPU")
    private ExerciseManager ejb;


    /**
     * This method will call the addExercise method of the interface to create 
     * an event in the database and in case of receiving an error we will send
     * an internal server error.
     * @param exercise the new exercise
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Exercise exercise) {
       try {
           ejb.addExercise(exercise);
        } catch (CreateException e) {
             LOGGER.severe(e.getMessage());
          throw new InternalServerErrorException(e.getMessage());
        }
    }

    /**
     * This method is used to edit the data in a database and in case the data 
     * does not exist to create it and in case of receiving an error we will
     * send an internal server error.
     * @param exercise updated exercise
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Exercise exercise) {
        try {
           ejb.updateExercise(exercise);
        } catch (UpdateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    /**
     * This method is used to remove data from the database and in case of 
     * receiving an error we will send an internal server error
     * @param id The exercise id to be deleted
     */
    
    @DELETE
    @Path("delete/{id}")
    public void remove(@PathParam("id") Long id) {
       try {
           ejb.deleteExercise(ejb.consultExerciseById(id));
        } catch (DeleteException | ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());

        }
    }

    /**
     * This method searches for exercises with a specific id
     * @param id the exercise id
     * @return Returns an exercise
     */
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

    /**
     * This method searches for all exercises
     * @return Return a list of exercises
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Exercise> consultAllExercises() {
        List<Exercise> exercise;
        try {
            exercise= ejb.consultAllExercises();
        } catch (ReadException e) {
            System.out.println(e.getMessage());
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
    }
        return exercise;
    }

    /**
     * This method searches for an exercise with a specific name
     * @param name the name of the exercise
     * @return Return an exercise list
     */
    @GET
    @Path("consultExerciseByName/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Exercise consultExerciseByName(@PathParam("name") String name) {
       Exercise exercise=null;
       Exercises enumE;
        try {
            enumE= Exercises.valueOf(name.toUpperCase());
            exercise=  ejb.consultExerciseByName(enumE);
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
    }
        return exercise;
    }

    
}
