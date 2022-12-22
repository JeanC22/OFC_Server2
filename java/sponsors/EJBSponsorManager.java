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
 * EJB Sponsor
 * @author Elias
 */
@Stateless
public class EJBSponsorManager implements SponsorManager{
    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;
    /**
     * Creates Sponsors
     * @param sponsor Sponsor object
     */
    @Override
    public void createSponsor(Sponsor sponsor) {
        em.persist(sponsor);
    }
    /**
     * Update Sponsor
     * @param sponsor Sponsor object
     */
    @Override
    public void updateSponsor(Sponsor sponsor) {
        em.merge(sponsor);
        em.flush();
    }
    /**
     * Delete Sponsors
     * @param sponsor Sponsor object
     */
    @Override
    public void removeSponsor(Sponsor sponsor) {
        sponsor = em.merge(sponsor);
        em.remove(sponsor);
    }
    /**
     * Finds a list for all Sponsor
     * @return List Sponsor
     */
    @Override
    public Set<Sponsor> findAllSponsor() {
        Set<Sponsor> sponsors = null;
        sponsors = new HashSet<>(em.createNamedQuery("findAllSponsor").getResultList());
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
        sponsor = (Sponsor) em.createNamedQuery("findSponsorByName").setParameter("name", name).getSingleResult();
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
        sponsors = new HashSet<>(em.createNamedQuery("findSponsorByDate").setParameter("date", date).getResultList());
        return sponsors;
    }
    
}
