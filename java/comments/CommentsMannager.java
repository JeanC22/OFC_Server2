/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.util.List;

/**
 *
 * @author Jeanpierr Caraballo
 *
 */
public interface CommentsMannager {

    /**
     * This method creates a new Coment in a event.
     *
     * @param coment The coment entity object containing new coment data.
     * @throws CreateException Thrown when any error or exception occurs during
     * creation.
     */
    public void createComent(Coment coment) throws CreateException;

    /**
     * This method delete a Coment from a client in a event.
     *
     * @param clientID type Long.
     * @param evetID type Long.
     * @throws DeleteException Thrown when any error or exception occurs during
     * deletion.
     */
    public void deleteComent(Long clientID, Long evetID) throws DeleteException;

    /**
     * This method updates an coment data in the data store.
     *
     * @param coment The coment entity object containing modified coment data
     * @throws UpdateException Thrown when any error or exception occurs during
     * update.
     */
    public void editComent(Coment coment) throws UpdateException;

    /**
     * This method gets a list with all Coments in the data store.
     *
     * @return A List of Coment entity objects.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    public List<Coment> getAllComents() throws ReadException;

    /**
     * This method gets a list with all Coments in the data store.
     *
     * @param subject the subject from the coment to be got.
     * @return A List of Coment entity objects.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    public List<Coment> findBySubject(String subject) throws ReadException;

    /**
     * This method gets a list with all Coments in the data store.
     *
     * @return A List of Coment entity objects.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    public List<Coment> findOrderByMoreRecent() throws ReadException;

    /**
     * This method gets a list with all Coments in the data store.
     *
     * @return A List of Coment entity objects.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    public List<Coment> findOrderByLastPublicate() throws ReadException;

    /**
     * This method gets a list with all Coments in the data store.
     *
     * @return A List of Coment entity objects.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    public List<Coment> findOrderByMoreRate() throws ReadException;

    /**
     * This method gets a list with all Coments in the data store.
     *
     * @return A List of Coment entity objects.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    public List<Coment> findOrderByLessRate() throws ReadException;

    /**
     * This method gets a list with all Coments from a user in the data store.
     *
     * @param clientID the clientID from the coment to be got.
     * @return A List of Coment entity objects.
     * @throws ReadException Thrown when any error or exception occurs during
     * reading.
     */
    public List<Coment> findMyComments(Long clientID) throws ReadException;

}
