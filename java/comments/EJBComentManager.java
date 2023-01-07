/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import entities.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jeanpierr Caraballo
 */
@Stateless
public class EJBComentManager implements CommentsMannager {

    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;

    @Override
    public void createComent(Coment coment) {
        try {
            em.persist(coment);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteComent(Long clientID, Long evetID) {
        try {
            System.out.println(clientID + "eventid " + evetID);
            Coment coment = new Coment();
            ComentId comentid = new ComentId();
            comentid.setClient_id(clientID);
            comentid.setEvent_id(evetID);
            coment.setComentid(comentid);  
            em.remove(em.merge(coment));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editComent(Coment coment) {
        try {
            if (!em.contains(coment)) {
                em.merge(coment);
            }
            em.flush();
        } catch (Exception e) {
            //add exception
        }
    }

    @Override
    public List<Coment> getAllComents() {
        List<Coment> coments = null;
        try {
            coments = em.createNamedQuery("coments.findAll")
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public List<Coment> findBySubject(String subject) {
        List<Coment> coments = null;
        try {
            coments = em.createNamedQuery("coments.findBySubject")
                    .setParameter("subject", subject).getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public List<Coment> findOrderByMoreRecent() {
        List<Coment> coments = null;

        try {
            coments = em.createNamedQuery("coments.OrderByMoreRecent")
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public List<Coment> findOrderByLastPublicate() {
        List<Coment> coments = null;

        try {
            coments = em.createNamedQuery("coments.OrderByLastPublicate")
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public List<Coment> findOrderByMoreRate() {
        List<Coment> coments = null;

        try {
            coments = em.createNamedQuery("coments.OrderByMoreRate")
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public List<Coment> findOrderByLessRate() {
        List<Coment> coments = null;

        try {
            coments = em.createNamedQuery("coments.OrderByLessRate")
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public List<Coment> findMyComments(Long clientID) {
        List<Coment> coments = null;

        try {
            coments = em.createNamedQuery("MyComents")
                    .setParameter("clientID", clientID)
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

  

}
