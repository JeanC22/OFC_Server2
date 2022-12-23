/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import comments.Coment;
import comments.CommentsMannager;
import java.util.HashSet;
import java.util.Set;
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
    private Set<Coment> coments = new HashSet<>();

    @Override
    public void createComent(Coment coment) {
        try {
            em.persist(coment);
        } catch (Exception e) {
            //add exception
        }
    }

    @Override
    public void deleteComent(Long id) {
        try {
            em.remove(em.merge(id));
        } catch (Exception e) {
            //add exception
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
    public Set<Coment> getAllComents() {
        try {
            coments = (Set<Coment>) em.createNamedQuery("coments.findAll")
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findBySubject(String subject) {
        try {
            coments = (Set<Coment>) em.createNamedQuery("coments.findBySubject")
                    .setParameter("subject", em.find(Coment.class, subject))
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findOrderByMoreRecent() {
        try {
            coments = (Set<Coment>) em.createNamedQuery("coments.OrderByMoreRecent")
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findOrderByLastPublicate() {
        try {
            coments = (Set<Coment>) em.createNamedQuery("coments.OrderByLastPublicate")
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findOrderByMoreRate() {
        try {
            coments = (Set<Coment>) em.createNamedQuery("coments.OrderByMoreRate")
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findOrderByLessRate() {
        try {
            coments = (Set<Coment>) em.createNamedQuery("coments.OrderByLessRate")
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findMyComments(Long id) {
        try {
            coments = (Set<Coment>) em.createNamedQuery("MyComents")
                    .setParameter("comClie", em.find(Coment.class, id))
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findMyComentOrderByMoreRecent(Long id) {
        try {
            coments = (Set<Coment>) em.createNamedQuery("MyComents.OrderByMoreRecent")
                    .setParameter("comClie", em.find(Coment.class, id))
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findMyComentOrderBylastPublication(Long id) {
        try {
            coments = (Set<Coment>) em.createNamedQuery("MyComents.OrderBylastPublication")
                    .setParameter("comClie", em.find(Coment.class, id))
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findMyComentOrderByMoreRate(Long id) {
        try {
            coments = (Set<Coment>) em.createNamedQuery("MyComents.OrderByMoreRate")
                    .setParameter("comClie", id)
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findMyComentOrderByLessRate(Long id) {
        try {
            coments = (Set<Coment>) em.createNamedQuery("MyComents.OrderByLessRate")
                    .setParameter("comClie", em.find(Coment.class, id))
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findMyPrivateComents(Long id) {
        try {
            coments = (Set<Coment>) em.createNamedQuery("MyComents.Private")
                    .setParameter("comClie", em.find(Coment.class, id))
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findMyPublicComents(Long id) {
        try {
            coments = (Set<Coment>) em.createNamedQuery("MyComents.Public")
                    .setParameter("comClie", em.find(Coment.class, id))
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    @Override
    public Set<Coment> findMyCommentByEvent(Long id) {
        try {
            coments = (Set<Coment>) em.createNamedQuery("MyComents.ByEvent")
                    .setParameter("comClie", em.find(Coment.class, id))
                    .getResultList();
        } catch (Exception e) {
            //add exception
        }
        return coments;
    }

    

}
