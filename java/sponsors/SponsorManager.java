/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sponsors;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.util.List;

/**
 * Local Interface for Sponsor EJB
 * @author Elias
 */

public interface SponsorManager {
   /**
     * This method create a new Sponsor
     * @param sponsor Sponsor object
     * @throws CreateException
     */
    public void createSponsor(Sponsor sponsor) throws CreateException;
    /**
     * This method update Sponsor data
     * @param sponsor Sponsor object
     * @throws UpdateException
     */
    public void updateSponsor(Sponsor sponsor) throws UpdateException;
    /**
     * This method remove Sponsor
     * @param sponsor Sponsor object
     * @throws DeleteException
     */
    public void removeSponsor(Sponsor sponsor) throws DeleteException;
    /**
     * This method get sponsor by id
     * @param id Sponsor id
     * @return Sponsor Object
     * @throws ReadException
     */
    public Sponsor findSponsor(Long id) throws ReadException;
    /**
     * This method get all sponsors
     * @return list Sponsor
     * @throws ReadException
     */
    public List<Sponsor> findAllSponsor() throws ReadException;
    /**
     * This method get Sponsor using the name
     * @param name Sponsor name
     * @return List Sponsor
     * @throws ReadException
     */
    public Sponsor findSponsorByName(String name) throws ReadException;
    /**
     * This method get Sponsor using date
     * @param strdate Date for Sponsor in String
     * @return List Sponsor
     * @throws ReadException
     */
    public List<Sponsor> findSponsorByDate(String strdate) throws ReadException;
}
