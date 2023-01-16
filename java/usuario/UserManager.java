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
    
    public void signUp(User user) throws CreateException;
    
    public void passwordChange(User user, String password) throws UpdateException;
    
    public void passwordForgotten(User user) throws UpdateException;
    
    public List<User> allusers() throws ReadException;
}
