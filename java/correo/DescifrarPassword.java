/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

/**
 *
 * @author 2dam
 */
public class DescifrarPassword {
    
    public String descifrarPassword(byte[] password) {
        byte[] decodedMessage = null;
        
        try {
            // Recupear Clave privada
            //...
            byte fileKey[] = fileReader("Private.key");//("EjemploRSA_Private.key");
          

            //Generamos una instancia de KeyFactory para el algoritmo RSA
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(fileKey);
            PrivateKey privateKey = keyFactory.generatePrivate(pKCS8EncodedKeySpec);

            //Desciframos el mensaje con el algoritmo RSA modo ECB y padding PKCS1Padding
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            decodedMessage = cipher.doFinal(password);
            
           

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String (decodedMessage);

    }
    
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
    
}
