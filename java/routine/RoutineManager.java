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

/**
 *
 * @author Aritz
 */
public interface RoutineManager {
    
    /**
     * This method searches for a routine by name
     * 
     * @param name the name of the exercise
     * @return Returns a routine
     * @throws ReadException It will be throwed when there is an error in 
     * reading the data.
     */
    public Routine consultRoutineByName(String name) throws ReadException;
 
    
    /**
     * This method searches all the routines of a client
     * 
     * @param id Client id
     * @return Returns a list of routines
     * @throws ReadException It will be throwed when there is an error in 
     * reading the data.
     */
    public List<Routine> consultAllClientRoutines(Integer id) throws ReadException;
    
    /**
     * This method is used to edit the data in a database and in case the data 
     * does not exist to create it
     * @param routine The routine to be created
     * @throws CreateException It will be launched when there is an error when
     * creating an routine.
     */
    public void addRoutine(Routine routine)throws CreateException;
    
    /**
     * This method is used to remove data from the database
     * @param routine The routine to be deleted
     * @throws DeleteException It will be launched when there is an error when
     * deleting an routine.
     */
    public void deleteRoutine(Routine routine) throws DeleteException;
    
    /**
     * This method is used to edit the data in a database and in case the data 
     * does not exist to create it
     * @param routine The routine to be updated
     * @throws UpdateException It will be launched when there is an error when 
     * updating an routine.
     */
    public void updateRoutine(Routine routine) throws UpdateException;
    
    /**
     * This method is uded to find all routines in the database
     * @return Returns all routines
     * @throws ReadException It will be throwed when there is an error in 
     * reading the data.
     */
    public List<Routine> consultAllRoutines() throws ReadException;
    
    /**
     * This method finds one routine with a concrete id
     * @param id Routine id
     * @return Returns the routine whith the required id
     * @throws ReadException 
     */
    public Routine consultRoutineById(Long id) throws ReadException;

}
