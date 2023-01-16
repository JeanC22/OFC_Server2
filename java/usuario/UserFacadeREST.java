/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;




import exceptions.CreateException;
import exceptions.ReadException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
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

    @EJB
    private UserManager ejb;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(User entity) {
        String pass;
        try {
            pass = cifrarTexto(entity.getPassword());
            System.out.println(pass);
            entity.setPassword(pass);
            ejb.signUp(entity);
        } catch (CreateException e) {
            System.out.println(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }

    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, User entity) {

    }

    @GET
    @Path("signIn/{username}/{password}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find(@PathParam("username") String username, @PathParam("password") String password) {
        User user;
        try {
            password = cifrarTexto(password);
           user = ejb.signIn(username, password);
        } catch (ReadException e) {
            System.out.println(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
        return user;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        List<User> list;
        try {
            
           list = ejb.allusers();
        } catch (ReadException e) {
            System.out.println(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
        return list;
    }
    public String cifrarTexto(String texto) {
        MessageDigest messageDigest;
        String passwd = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");//"SHA-256";
            byte dataBytes[] = texto.getBytes(); // Texto a bytes
            messageDigest.update(dataBytes);
            byte resumen[] = messageDigest.digest(); // Se calcula el resumen
            passwd = Hexadecimal(resumen);
            
             } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return passwd;
    }
    
    static String Hexadecimal(byte[] resumen) {
        StringBuilder result = new StringBuilder();
       for(Byte aByte : resumen){
           result.append(String.format("%02x", aByte));
       }
       return result.toString();
    }
}
