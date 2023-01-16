/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import exceptions.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author iker
 */

@Stateless
public class EJBUserManager implements UserManager{

    
    @PersistenceContext(unitName = "OFC_ServerWebPU")
    private EntityManager em;
  
    @Override
    public User signIn(String username, String password) throws ReadException {
        List<User> list;
        User usu;
        try {
            list = em.createNamedQuery("findUser").setParameter("username", username).setParameter("password", password).getResultList();
            usu = list.get(0);
        } catch (Exception e) {
            throw new ReadException();
        }
        
        return usu;
    }

    @Override
    public void signUp(User user) throws CreateException {
        try {
            
            em.persist(user);
        } catch (Exception e) {
            throw new CreateException();
        }
        
    }
        
    @Override
    public void passwordChange(User user, String password) throws UpdateException {
        try{
            if (!em.contains(user)) {
                em.merge(user).setPassword(password);
                em.flush();
            }
        }catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }     

    @Override
    public void passwordForgotten(User user) throws UpdateException {
       
    }

    @Override
    public List<User> allusers() throws ReadException {
        List<User> list;
        try {
            list = em.createNamedQuery("findAllUser").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return list;
    }
    
    
}
