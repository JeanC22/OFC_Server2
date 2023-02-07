/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import exceptions.*;
import java.util.List;

/**
 *
 * @author iker
 */
public interface UserManager {
    
    public User signIn(String username, String password) throws ReadException;
    
    public void signUp(Client clie) throws CreateException;
    
    public void editPasswordChange(Long id, String newPassword, String oldPassword) throws UpdateException;
    
    public void editPasswordForgotten(Long id,String password,String passwordHash) throws UpdateException;
    
    public List<User> allusers() throws ReadException;
}
