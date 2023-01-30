/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import usuario.Client;
import event.Event;
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
 * @author Jeanpierr Caraballo
 */
@Stateless
public class EJBComentManager implements CommentsMannager {

    /**
     * EntityManager for OFC_ServerWebPU persistence unit.
     */
    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;

    /**
     * This method creates a new account in the data store.
     *
     * @param coment The Coment entity object containing new coment data.
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     * @throws exceptions.ReadException
     */
    @Override
    public void createComent(Coment coment) throws CreateException, ReadException {
        try {

            if (!em.contains(coment.getEvent())) {
                coment.setEvent(em.merge(em.find(Event.class, coment.getComentid().getEvent_id())));
            }
            if (!em.contains(coment.getComClie())) {
                coment.setComClie(em.merge(em.find(Client.class, coment.getComentid().getClient_id())));
            }
            em.persist(coment);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    /**
     * This method removes an user coment in a event from the data store.
     *
     * @param clientID the id for the coment to be deleted.
     * @param evetID the id for the coment to be deleted.
     * @throws DeleteException Thrown when any error or exception occurs during
     * deletion.
     */
    @Override
    public void deleteComent(Long clientID, Long evetID) throws DeleteException {
        try {
            Coment coment = new Coment();
            ComentId comentid = new ComentId();
            comentid.setClient_id(clientID);
            comentid.setEvent_id(evetID);
            coment.setComentid(comentid);
            em.remove(em.merge(coment));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    /**
     * This method updates a movement data in the data store.
     *
     * @param coment The Coment entity object containing modified Coment data.
     * @throws UpdateException Thrown when any error or exception occurs during
     * update.
     */
    @Override
    public void editComent(Coment coment) throws UpdateException {
        try {
            if (!em.contains(coment)) {
                em.merge(coment);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    /**
     * This method obtains a list with all Coment in the data store.
     *
     * @return An Coment entity object containing account data.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    @Override
    public List<Coment> getAllComents() throws ReadException {
        List<Coment> coments;
        try {
            coments = em.createNamedQuery("coments.findAll").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return coments;
    }

    /**
     * This method obtains a list with all Coment in the data store.
     *
     * @param subject
     * @return A List Coment entity object containing account data.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    @Override
    public List<Coment> findBySubject(String subject) throws ReadException {
        List<Coment> coments = null;
        try {
            coments = em.createNamedQuery("coments.findBySubject")
                    .setParameter("subject", subject + "%").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return coments;
    }

    /**
     * This method obtains a list with all Coment in the data store.
     *
     * @return A List Coment entity object containing account data.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    @Override
    public List<Coment> findOrderByMoreRecent() throws ReadException {
        List<Coment> coments = null;
        try {
            coments = em.createNamedQuery("coments.OrderByMoreRecent")
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return coments;
    }

    /**
     * This method obtains a list with all Coment in the data store.
     *
     * @return A List Coment entity object containing account data.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    @Override
    public List<Coment> findOrderByLastPublicate() throws ReadException {
        List<Coment> coments = null;

        try {
            coments = em.createNamedQuery("coments.OrderByLastPublicate")
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return coments;
    }

    /**
     * This method obtains a list with all Coment in the data store.
     *
     * @return A List Coment entity object containing account data.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    @Override
    public List<Coment> findOrderByMoreRate() throws ReadException {
        List<Coment> coments = null;

        try {
            coments = em.createNamedQuery("coments.OrderByMoreRate")
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return coments;
    }

    /**
     * This method obtains a list with all Coment in the data store.
     *
     * @return A List Coment entity object containing account data.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    @Override
    public List<Coment> findOrderByLessRate() throws ReadException {
        List<Coment> coments = null;

        try {
            coments = em.createNamedQuery("coments.OrderByLessRate")
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return coments;
    }

    /**
     * This method obtains a list with all Coment in the data store.
     *
     * @return A List Coment entity object containing account data.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    @Override
    public List<Coment> findMyComments(Long clientID) throws ReadException {
        List<Coment> coments = null;

        try {
            coments = em.createNamedQuery("MyComents")
                    .setParameter("clientID", clientID)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return coments;
    }

    @Override
    public List<Coment> EventComents(Long eventID) throws ReadException {
        List<Coment> coments = null;

        try {
            coments = em.createNamedQuery("EventComents")
                    .setParameter("eventID", eventID)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return coments;
    }

}
