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
    public void deleteComent(Coment coment);
    
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
    public Set<Coment> getAllComents(Coment coment);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findBySubject(Coment coment);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findOrderByMoreRecent(Coment coment);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findOrderByLastPublicate(Coment coment);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findOrderByMoreRate(Coment coment);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findOrderByLessRate(Coment coment);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findMyComments(Coment coment);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findOrderBylastPublication(Coment coment);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findPrivateComents(Coment coment);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findPublicComents(Coment coment);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public Set<Coment> findByEvent(Coment coment);
    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */

}
