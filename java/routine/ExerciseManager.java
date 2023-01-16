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
public interface ExerciseManager {

    /**
     * This method searches for an exercise by id
     * 
     * @param id Id of the exercise
     * @return Returns an exercise
     * @throws ReadException It will be throwed when there is an error in 
     * reading the data.
     */
    public Exercise consultExerciseById(Long id)throws ReadException;
    
    /**
     * This method searches for exercises by name
     * 
     * @param exercises Name of the exercise
     * @return Returns a list of exercises
     * @throws ReadException It will be throwed when there is
     * an error in reading the data.
     */
    public Exercise consultExerciseByName(Exercises exercises) throws ReadException;
    
    /**
     * This method searches all exercises
     * 
     * @return Returns a list of exercises
     * @throws ReadException It will be throwed when there is 
     * an error in reading the data.
     */
    public List<Exercise> consultAllExercises() throws ReadException;
    
    /**
     * This method adds a new exercise
     * 
     * @param exercise The exercise to be added
     * @throws CreateException It will be launched when there is an error when
     * creating an exercise.
     */
    public void addExercise(Exercise exercise)throws CreateException;
    
    /**
     * This method delete exercise
     * 
     * @param id The exercise id to be deleted
     * @throws DeleteException It will be launched when there is an error when
     * deleting an exercise.
     */
    public void deleteExercise(Exercise id) throws DeleteException;
    
    /**
     * This method updates an exercise
     * 
     * @param exercise The exercise to be updated
     * @throws UpdateException It will be launched when there is an error when 
     * updating an exercise.
     */
    public void updateExercise(Exercise exercise) throws UpdateException;
}
