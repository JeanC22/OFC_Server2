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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aritz
 */
@Stateless
public class EJBRoutineManager implements RoutineManager{
 /**
     * EntityManager for DataModelExamplePU persistence unit.
     */
   
    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;
         
    @Override
    public List<Routine> consultRoutineByName(String name) throws ReadException {
       List<Routine> routines;
        try {
            routines = em.createNamedQuery("consultRoutineByName").getResultList();
           
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
         return routines;
    }

    @Override
    public Set<Routine> consultRoutineByExercise(Integer id) throws ReadException {
        Set<Routine> routines= null;
        try {
            
            Exercise exercise= em.find(Exercise.class, id);
             List<Routine> allRoutines=  em.createNamedQuery("consultAllRoutines").getResultList();
             routines= new HashSet<>();
             for (Routine r : allRoutines) 
                 if (r.getEjercicios().contains(exercise)) 
                     routines.add(r);
          
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return routines;
    }

    @Override
    public List<Routine> consultAllRoutines(Integer id) throws ReadException {
         List<Routine> routines= null;
        try {
             routines= em.createNamedQuery("findAllRoutines").setParameter("id", id).getResultList();
             
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
       return routines;
    }

    @Override
    public void addRoutine(Routine routine) throws CreateException {
        try {
            em.persist(routine);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updateRoutine(Routine routine) throws UpdateException {
        try {
            if(!em.contains(routine))
                em.merge(routine);
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void deleteRoutine(Routine routine) throws DeleteException {
         try {
             em.remove(em.merge(routine));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }
    
}
