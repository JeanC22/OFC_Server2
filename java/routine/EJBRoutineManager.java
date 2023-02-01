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
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aritz
 */
@Stateless
public class EJBRoutineManager implements RoutineManager {

    /**
     * EntityManager for DataModelExamplePU persistence unit.
     */
    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;
    private static final Logger LOGGER = Logger.getLogger("routine.EJBRoutineManager");

    @Override
    public Routine consultRoutineByName(String name) throws ReadException {
        Routine routine;
        List<Routine> list;
        try {
           
            list=em.createNamedQuery("consultRoutineByName").setParameter("name", name).getResultList();
            routine = list.get(0);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return routine;
    }


    @Override
    public List<Routine> consultAllClientRoutines(Integer id) throws ReadException {
        List<Routine> routines = null;
        int clieId = id;

        try {
            routines = em.createNamedQuery("consultAllRoutines").getResultList();

            if (!routines.isEmpty()) {

                for (int i = 0; i < routines.size(); i++) {
                    if (routines.get(i).getClie().getId() != clieId) {

                        routines.remove(i);
                    }
                }
            }

        } catch (Exception e) {
            Logger.getLogger(EJBRoutineManager.class.getName()).log(Level.SEVERE, null, e);

            throw new ReadException(e.getMessage());
        }
        return routines;
    }

    @Override
    public void addRoutine(Routine routine) throws CreateException {
   
        try {
         
            em.persist(routine);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new CreateException(e.getMessage());

        }
    }

    @Override
    public void updateRoutine(Routine routine) throws UpdateException {
        try {
            if (!em.contains(routine)) {
                em.merge(routine);
            }
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

    @Override
    public List<Routine> consultAllRoutines() throws ReadException {
        List<Routine> routines;
        try {
            routines = em.createNamedQuery("consultAllRoutines").getResultList();
        } catch (Exception e) {

            throw new ReadException(e.getMessage());

        }
        return routines;
    }

    @Override
    public Routine consultRoutineById(Long id) throws ReadException {
        Routine routine;
        List<Routine> list;

        try {
            list = em.createNamedQuery("consultRoutineById").setParameter("id", id).getResultList();
            routine = list.get(0);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return routine;
    }

}
