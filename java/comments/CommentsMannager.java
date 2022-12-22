/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import entities.Event;
import java.util.Set;

/**
 *
 * @author Jeanpierr Caraballo
 *
 */
public interface CommentsMannager {

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public void createComent(Coment coment);

    /**
     * This method delete a comment in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public void deleteComent(Long id);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public void editComent(Coment coment);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> getAllComents();

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findBySubject(String subject);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findOrderByMoreRecent();

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findOrderByLastPublicate();

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findOrderByMoreRate();

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findOrderByLessRate();

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findMyComments(Long id);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findMyComentOrderByMoreRecent(Long id);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findMyComentOrderBylastPublication(Long id);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findMyComentOrderByMoreRate(Long id);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findMyComentOrderByLessRate(Long id);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findMyPrivateComents(Long id);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findMyPublicComents(Long id);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findMyCommentByEvent(Long id);
    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */

}
