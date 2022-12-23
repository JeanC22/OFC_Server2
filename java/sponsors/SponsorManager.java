/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sponsors;

import java.util.Date;
import java.util.Set;
import javax.ejb.Local;

/**
 * Local Interface for Sponsor EJB
 * @author Elias
 */
@Local
public interface SponsorManager {
    /**
     * This method create a new Sponsor
     * @param sponsor Sponsor object
     */
    public void createSponsor(Sponsor sponsor);
    /**
     * This method update Sponsor data
     * @param sponsor Sponsor object
     */
    public void updateSponsor(Sponsor sponsor);
    /**
     * This method remove Sponsor
     * @param sponsor Sponsor object
     */
    public void removeSponsor(Sponsor sponsor);
    /**
     * This method get sponsor by id
     * @param id Sponsor id
     * @return Sponsor Object
     */
    public Sponsor findSponsor(Long id);
    /**
     * This method get all sponsors
     * @return list Sponsor
     */
    public Set<Sponsor> findAllSponsor();
    /**
     * This method get Sponsor using the name
     * @param name Sponsor name
     * @return List Sponsor
     */
    public Sponsor findSponsorByName(String name);
    /**
     * This method get Sponsor using date
     * @param date Sponsor date
     * @return List Sponsor
     */
    public Set<Sponsor> findSponsorByDate(Date date);
}
