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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aritz
 */
public class EJBExerciseManager implements ExerciseManager{

     private Set<Exercise> exercise;
    
    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;
    @Override
    public Set<Exercise> consultExerciseByName(String name) throws ReadException {
         try {
            exercise= (Set<Exercise>) em.find(Exercise.class, name);
            return exercise;
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    @Override
    public Set<Exercise> consultAllExercises() throws ReadException {
          try {
             exercise=(Set<Exercise>) (Exercise) em.createNamedQuery("findAllExercises").getResultList();
             return exercise;
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    @Override
    public void addExercise(Exercise exercise) throws CreateException {
         try {
            em.persist(exercise);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void deleteExercise(Exercise exercise) throws DeleteException {
        try {
             em.remove(em.merge(exercise));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public void updateExercise(Exercise exercise) throws UpdateException {
         try {
            if(!em.contains(exercise))
                em.merge(exercise);
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }


    
}
