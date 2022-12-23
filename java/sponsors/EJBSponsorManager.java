/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sponsors;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 2dam
 */
@Stateless
public class EJBSponsorManager implements SponsorManager{
    @PersistenceContext
    private EntityManager em;
    /**
     * Creates Sponsors
     * @param sponsor Sponsor object
     */
    @Override
    public void createSponsor(Sponsor sponsor) {
        try {
            em.persist(sponsor);
        } catch (Exception e) {
        }
        
    }
    /**
     * Update Sponsor
     * @param sponsor Sponsor object
     */
    @Override
    public void updateSponsor(Sponsor sponsor) {
        try {
            em.merge(sponsor);
            em.flush();
        } catch (Exception e) {
        }
        
    }
    /**
     * Delete Sponsors
     * @param sponsor Sponsor object
     */
    @Override
    public void removeSponsor(Sponsor sponsor) {
        try {
            sponsor = em.merge(sponsor);
            em.remove(sponsor);
        } catch (Exception e) {
        }
        
    }
    /**
     * Finds a list for all Sponsor
     * @return List Sponsor
     */
    @Override
    public Set<Sponsor> findAllSponsor() {
        Set<Sponsor> sponsors = null;
        try {
           sponsors = new HashSet<>(em.createNamedQuery("findAllSponsor")
                   .getResultList());
           
        } catch (Exception e) {
        }
        return sponsors;
    }
    /**
     * Finds a list of sponsor by name
     * @param name The name for the Sponsor
     * @return Sponsor object
     */
    @Override
    public Sponsor findSponsorByName(String name) {
        Sponsor sponsor = null;
        try {
            sponsor = (Sponsor) em.createNamedQuery("findSponsorByName")
                    .setParameter("name", name).getSingleResult();
        } catch (Exception e) {
        }
        
        return sponsor;
    }
    /**
     * Finds a list of Sponsor by date
     * @param date The date for Sponsor
     * @return List Sponsor
     */
    @Override
    public Set<Sponsor> findSponsorByDate(Date date) {
        Set<Sponsor> sponsors = null;
        try {
            sponsors = new HashSet<>(em.createNamedQuery("findSponsorByDate")
                    .setParameter("date", date).getResultList());
        } catch (Exception e) {
        }
        
        return sponsors;
    }

    @Override
    public Sponsor findSponsor(Long id) {
        Sponsor sponsor;
        sponsor = em.find(Sponsor.class, id);
        return sponsor;
    }
    
}

