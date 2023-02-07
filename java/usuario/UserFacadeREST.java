/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import exceptions.CreateException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author 2dam
 */
@Path("user")
public class UserFacadeREST {

    private Logger LOGGER = Logger.getLogger(UserFacadeREST.class.getName());

    @EJB
    private UserManager ejb;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Client entity) {
        LOGGER.severe("Create a new client:");

        String pass;
        try {
            pass = cifrarTexto(entity.getPassword());
            entity.setPassword(pass);
            ejb.signUp(entity);
        } catch (CreateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }

    }

    @PUT
    @Path("/changePassword/{id}/{newPassword}/{oldPassword}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, @PathParam("newPassword") String newPassword, @PathParam("oldPassword") String oldPassword) {
        LOGGER.severe("Changing password");

        oldPassword = cifrarTexto(oldPassword);
        newPassword = cifrarTexto(newPassword);
        try {
            ejb.editPasswordChange(id, newPassword, oldPassword);
            LOGGER.severe("password changed");
        } catch (UpdateException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @PUT
    @Path("/forgotten/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id) {
        LOGGER.severe("Changing password");
        String password = "pepe", passwordhash = "pepe";
        try {
            passwordhash = cifrarTexto(passwordhash);
            ejb.editPasswordForgotten(id, password, passwordhash);
            LOGGER.severe("password changed");
        } catch (UpdateException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @GET
    @Path("signIn/{username}/{password}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find(@PathParam("username") String username, @PathParam("password") String password) {
        LOGGER.severe("SingIn");
        User user;
        try {
            password = cifrarTexto(password);
            user = ejb.signIn(username, password);
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
        return user;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        LOGGER.severe("Find all user");
        List<User> list;
        try {
            list = ejb.allusers();
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
        return list;
    }

    public static String cifrarTexto(String texto) {

        MessageDigest messageDigest;
        String passwd = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");//"SHA-256";
            byte dataBytes[] = texto.getBytes(); // Texto a bytes
            messageDigest.update(dataBytes);
            byte resumen[] = messageDigest.digest(); // Se calcula el resumen
            passwd = Hexadecimal(resumen);

        } catch (NoSuchAlgorithmException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
        return passwd;
    }

    public static String Hexadecimal(byte[] resumen) {
        StringBuilder result = new StringBuilder();
        for (Byte aByte : resumen) {
            result.append(String.format("%02x", aByte));
        }
        return result.toString();
    }
}
