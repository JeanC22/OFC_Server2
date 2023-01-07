/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import entities.Client;
import java.util.List;
import javax.ejb.Local;

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
    public void deleteComent(Long clientID, Long evetID);

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
    public List<Coment> getAllComents();

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public List<Coment> findBySubject(String subject);

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public List<Coment> findOrderByMoreRecent();

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public List<Coment> findOrderByLastPublicate();

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public List<Coment> findOrderByMoreRate();

    /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public List<Coment> findOrderByLessRate();
    
 /**
     * This method creates a new message in a event.
     *
     * @param coment The coment entity object containing new account data
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public List<Coment> findMyComments(Long clientID);


}
