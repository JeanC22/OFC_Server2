/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routine;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import java.util.Set;

import exceptions.UpdateException;
import javax.ejb.Local;

/**
 *
 * @author Aritz
 */
@Local
public interface RoutineManager {
    
    public Set<Routine> consultRoutineByName(String name) throws ReadException;
    
    public Set<Routine> consultRoutineByExercise(Integer id) throws ReadException;
    
    public Set<Routine> consultAllRoutines(Integer id) throws ReadException;
    
    public void addRoutine(Routine routine)throws CreateException;
    
    public void deleteRoutine(Routine routine) throws DeleteException;
    
    public void updateRoutine(Routine routine) throws UpdateException;

}
