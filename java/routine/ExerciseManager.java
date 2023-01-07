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

/**
 *
 * @author Aritz
 */
public interface ExerciseManager {

    public Exercise consultExerciseById(Long id)throws ReadException;
    
    public List<Exercise> consultExerciseByName(String name) throws ReadException;
    
    public List<Exercise> consultAllExercises() throws ReadException;
    
    public void addExercise(Exercise exercise)throws CreateException;
    
    public void deleteExercise(Exercise exercise) throws DeleteException;
    
    public void updateExercise(Exercise exercise) throws UpdateException;
}
