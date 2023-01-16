/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sponsors;

import java.util.logging.Logger;
import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * EJB for Sponsor
 * @author Elias
 */
@Stateless
public class EJBSponsorManager implements SponsorManager{
    
    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;
    private static final Logger LOGGER = Logger.getLogger("sponsors.EJBSponsorManager");
    /**
     * Creates Sponsors
     * @param sponsor Sponsor object
     * @throws CreateException
     */
    @Override
    public void createSponsor(Sponsor sponsor) throws CreateException{
        try {
            em.persist(sponsor);
            LOGGER.info("Sponsor Created");
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new CreateException(e.getMessage());
        }
        
    }
    /**
     * Update Sponsor
     * @param sponsor Sponsor object
     * @throws UpdateException
     */
    @Override
    public void updateSponsor(Sponsor sponsor) throws UpdateException{
        try {
            if(!em.contains(sponsor)){
                em.merge(sponsor);
                
            }
            em.flush();
            LOGGER.info("Sponsor updated");
            
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new UpdateException(e.getMessage());
        }
        
    }
    /**
     * Delete Sponsors
     * @param sponsor Sponsor object
     * @throws DeleteException
     */
    @Override
    public void removeSponsor(Sponsor sponsor) throws DeleteException{
        try {
            em.remove(em.merge(sponsor));
            LOGGER.info("Sponsor removed");
        } catch (Exception e){ 
            LOGGER.severe(e.getMessage());
            throw new DeleteException(e.getMessage());
        }
        
    }
    /**
     * list for all Sponsor
     * @return List Sponsor
     * @throws ReadException 
     */
    @Override
    public List<Sponsor> findAllSponsor() throws ReadException{
        List<Sponsor> sponsors;
        try {
            LOGGER.info("Reading all Sponsor");
           sponsors = em.createNamedQuery("findAllSponsors").getResultList();
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new ReadException(e.getMessage());
        }
        return sponsors;
    }
    /**
     * list of sponsor by name
     * @param name The name for the Sponsor
     * @return Sponsor object
     * @throws ReadException
     */
    @Override
    public Sponsor findSponsorByName(String name) throws ReadException{
        Sponsor sp;
        try {
            LOGGER.info("Reading sponsor by name");
            sp = (Sponsor) em.createNamedQuery("findSponsorByName")
                    .setParameter("name", name).getSingleResult();
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new ReadException(e.getMessage());
        }
        
        return sp;
    }
    /**
     * list of Sponsor by date
     * @param strdate Date for Sponsor in String
     * @return List Sponsor
     * @throws ReadException
     */
    @Override
    public List<Sponsor> findSponsorByDate(String strdate) throws ReadException{
        List<Sponsor> sponsors = null;
        
        try {
            Date dateFormat = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(strdate);
            try{
                
            LOGGER.info("Reading sponsor by date");
            sponsors = em.createNamedQuery("findSponsorByDate")
                    .setParameter("date", dateFormat).getResultList();
            }catch(Exception e){
                throw new ReadException(e.getMessage());
            }
            
        } catch (ParseException e) {
            LOGGER.severe(e.getMessage());
            throw new ReadException(e.getMessage());
        }
   
        
        return sponsors; }
    /**
     * Find Sponsor by ID 
     * @param id Id Sponsor
     * @return Sponsor
     * @throws ReadException
     */
    @Override
    public Sponsor findSponsor(Long id) throws ReadException{
        Sponsor sponsor;
        try {
            LOGGER.info("Reading sponsor by ID");
           sponsor = em.find(Sponsor.class, id); 
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new ReadException(e.getMessage());
        }
        
        return sponsor;
    }
    
}

