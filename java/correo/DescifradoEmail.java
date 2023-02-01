/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.ResourceBundle;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author 2dam
 */
public class DescifradoEmail {
    
    static String sSalt="[B@7bb11784";
    private static final byte[] salt = sSalt.getBytes();
    private String clave= "ofc";
    
 public String descifrarEmailPassword() {
        String ret = null;

        // Fichero leído
        byte[] fileContent = fileReader("EmailPasswd.dat"); // Path del fichero EjemploAES.dat
        
        KeySpec keySpec = null;
        SecretKeyFactory secretKeyFactory = null;
        try {
            // Obtenemos el keySpec
            
           keySpec = new PBEKeySpec(clave.toCharArray(),salt,65536,128); // AES-128

            // Obtenemos una instancide de SecretKeyFactory con el algoritmo "PBKDF2WithHmacSHA1"
             secretKeyFactory= SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            // Generamos la clave
           byte[] key = secretKeyFactory.generateSecret(keySpec).getEncoded();

            // Creamos un SecretKey usando la clave + salt
           SecretKey privateKey = new SecretKeySpec(key, "AES");

            // Obtenemos una instancide de Cipher con el algoritmos que vamos a usar "AES/CBC/PKCS5Padding"
             Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
     
            // Leemos el fichero codificado 
            IvParameterSpec ivParam = new IvParameterSpec(Arrays.copyOfRange(fileContent, 0, 16));

            // Iniciamos el Cipher en ENCRYPT_MODE y le pasamos la clave privada y el ivParam
             cipher.init(Cipher.DECRYPT_MODE, privateKey, ivParam);
            // Le decimos que descifre
            byte[] decodedMessage = cipher.doFinal(Arrays.copyOfRange(fileContent, 16, fileContent.length));

            // Texto descifrado
            ret = new String(decodedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
 
  public String descifrarEmailCorreo() {
        String ret = null;

        // Fichero leído
        byte[] fileContent = fileReader("Email.dat"); // Path del fichero EjemploAES.dat
         //ResourceBundle.getBundle(sSalt).getString("Clave");
        KeySpec keySpec = null;
        SecretKeyFactory secretKeyFactory = null;
        try {
            // Obtenemos el keySpec
            
           keySpec = new PBEKeySpec(clave.toCharArray(),salt,65536,128); // AES-128

            // Obtenemos una instancide de SecretKeyFactory con el algoritmo "PBKDF2WithHmacSHA1"
             secretKeyFactory= SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            // Generamos la clave
           byte[] key = secretKeyFactory.generateSecret(keySpec).getEncoded();

            // Creamos un SecretKey usando la clave + salt
           SecretKey privateKey = new SecretKeySpec(key, "AES");

            // Obtenemos una instancide de Cipher con el algoritmos que vamos a usar "AES/CBC/PKCS5Padding"
             Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
     
            // Leemos el fichero codificado 
            IvParameterSpec ivParam = new IvParameterSpec(Arrays.copyOfRange(fileContent, 0, 16));

            // Iniciamos el Cipher en ENCRYPT_MODE y le pasamos la clave privada y el ivParam
             cipher.init(Cipher.DECRYPT_MODE, privateKey, ivParam);
            // Le decimos que descifre
            byte[] decodedMessage = cipher.doFinal(Arrays.copyOfRange(fileContent, 16, fileContent.length));

            // Texto descifrado
            ret = new String(decodedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
  
     public String cifrarTexto(String clave, String mensaje) {
        String ret = null;
        KeySpec keySpec = null;
        SecretKeyFactory secretKeyFactory = null;
        
        try {
            
            // Obtenemos el keySpec           
            keySpec = new PBEKeySpec(clave.toCharArray(),salt,65536,128); // AES-128
            
            // Obtenemos una instancide de SecretKeyFactory con el algoritmo "PBKDF2WithHmacSHA1"
            secretKeyFactory= SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            // Generamos la clave
            
            byte[] key = secretKeyFactory.generateSecret(keySpec).getEncoded();
            
            // Creamos un SecretKey usando la clave + salt
            SecretKey privateKey = new SecretKeySpec(key, "AES");// AES;

            // Obtenemos una instancide de Cipher con el algoritmos que vamos a usar "AES/CBC/PKCS5Padding"
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            // Iniciamos el Cipher en ENCRYPT_MODE y le pasamos la clave privada
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);

            // Le decimos que cifre (método doFinal())
            byte[] encodedMessage= cipher.doFinal(mensaje.getBytes());
            
            // Obtenemos el vector CBC del Cipher (método getIV())
                    byte[] iv= cipher.getIV();

            // Guardamos el mensaje codificado: IV (16 bytes) + Mensaje
                    byte[] combined = concatArrays(iv,encodedMessage);
            // Escribimos el fichero cifrado 
            fileWriter("Email.dat", combined);

            // Retornamos el texto cifrado
            ret = new String(encodedMessage);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
     
         private void fileWriter(String path, byte[] text) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
         
             private byte[] concatArrays(byte[] array1, byte[] array2) {
        byte[] ret = new byte[array1.length + array2.length];
        System.arraycopy(array1, 0, ret, 0, array1.length);
        System.arraycopy(array2, 0, ret, array1.length, array2.length);
        return ret;
    }
    

    /**
     * Retorna el contenido de un fichero
     *
     * @param path Path del fichero
     * @return El texto del fichero
     */
    private byte[] fileReader(String path) {
        byte ret[] = null;
        File file = new File(path);
        try {
            ret = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
    
    
     /*public static void main(String[] args) {
         DescifradoEmail d = new DescifradoEmail();
         //d.cifrarTexto("ofc", "ofc.dam2@gmail.com");
         System.out.println("Correo: "+d.descifrarEmailCorreo());
         System.out.println("Password: "+ d.descifrarEmailPassword());
    }*/
}
