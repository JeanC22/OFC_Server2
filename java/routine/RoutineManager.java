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

/**
 *
 * @author Aritz
 */
public interface RoutineManager {
    
    public List<Routine> consultRoutineByName(String name) throws ReadException;
    
    public Set<Routine> consultRoutineByExercise(Integer id) throws ReadException;
    
    public List<Routine> consultAllRoutines(Integer id) throws ReadException;
    
    public void addRoutine(Routine routine)throws CreateException;
    
    public void deleteRoutine(Routine routine) throws DeleteException;
    
    public void updateRoutine(Routine routine) throws UpdateException;

}
