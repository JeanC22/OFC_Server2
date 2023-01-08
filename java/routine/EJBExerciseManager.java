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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aritz
 */
@Stateless
public class EJBExerciseManager implements ExerciseManager{

    
    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;
    

    
     @Override
    public Exercise consultExerciseById(Long id) throws ReadException {
        List<Exercise> exercise= null;
         try {
            exercise= em.createNamedQuery("consultExerciseById").setParameter("id", id).getResultList();
           
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
          return (Exercise) exercise;
    }
    
    @Override
    public Exercise consultExerciseByName(String name) throws ReadException {
         Exercise exercise= null;
         try {
            exercise= (Exercise) em.createNamedQuery("consultExerciseByName").setParameter("name", name);
           
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
          return exercise;
    }

    @Override
    public List<Exercise> consultAllExercises() throws ReadException {
        List<Exercise> exercise= null;
          try {
             exercise=  em.createNamedQuery("findAllExercises").getResultList();
             
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
          return exercise;
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
