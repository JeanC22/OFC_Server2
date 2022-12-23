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
import java.util.Set;
import javax.ejb.Local;

/**
 *
 * @author Aritz
 */
//@Local
public interface ExerciseManager {
    
    public Set<Exercise> consultExerciseByName(String name) throws ReadException;
    
    public Set<Exercise> consultAllExercises() throws ReadException;
    
    public void addExercise(Exercise exercise)throws CreateException;
    
    public void deleteExercise(Exercise exercise) throws DeleteException;
    
    public void updateExercise(Exercise exercise) throws UpdateException;
}
