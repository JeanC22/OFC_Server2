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
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 2dam
 */
@Stateless
public class EJBSponsorManager implements SponsorManager{
    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;
    /**
     * Creates Sponsors
     * @param sponsor Sponsor object
     * @throws exceptions.CreateException
     */
    @Override
    public void createSponsor(Sponsor sponsor) throws CreateException{
        try {
            em.persist(sponsor);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
        
    }
    /**
     * Update Sponsor
     * @param sponsor Sponsor object
     * @throws exceptions.UpdateException
     */
    @Override
    public void updateSponsor(Sponsor sponsor) throws UpdateException{
        try {
            em.merge(sponsor);
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
        
    }
    /**
     * Delete Sponsors
     * @param sponsor Sponsor object
     * @throws exceptions.DeleteException
     */
    @Override
    public void removeSponsor(Sponsor sponsor) throws DeleteException{
        try {
            sponsor = em.merge(sponsor);
            em.remove(sponsor);
        } catch (Exception e){ 
            throw new DeleteException(e.getMessage());
        }
        
    }
    /**
     * Finds a list for all Sponsor
     * @return List Sponsor
     * @throws exceptions.ReadException
     */
    @Override
    public List<Sponsor> findAllSponsor() throws ReadException{
        List<Sponsor> sponsors = null;
        try {
           sponsors = em.createNamedQuery("findAllSponsor")
                   .getResultList();
           
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return sponsors;
    }
    /**
     * Finds a list of sponsor by name
     * @param name The name for the Sponsor
     * @return Sponsor object
     * @throws exceptions.ReadException
     */
    @Override
    public Sponsor findSponsorByName(String name) throws ReadException{
        Sponsor sp;
        try {
            sp = (Sponsor) em.createNamedQuery("findSponsorByName")
                    .setParameter("name", name).getSingleResult();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        
        return sp;
    }
    /**
     * Finds a list of Sponsor by date
     * @param date The date for Sponsor
     * @return List Sponsor
     * @throws exceptions.ReadException
     */
    @Override
    public List<Sponsor> findSponsorByDate(Date date) throws ReadException{
        List<Sponsor> sponsors = null;
        try {
            sponsors = em.createNamedQuery("findSponsorByDate")
                    .setParameter("date", date).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        
        return sponsors;
    }
    /**
     * Find Sponsor by ID 
     * @param id Id Sponsor
     * @return Sponsor
     * @throws exceptions.ReadException
     */
    @Override
    public Sponsor findSponsor(Long id) throws ReadException{
        Sponsor sponsor;
        try {
           sponsor = em.find(Sponsor.class, id); 
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        
        return sponsor;
    }
    
}

