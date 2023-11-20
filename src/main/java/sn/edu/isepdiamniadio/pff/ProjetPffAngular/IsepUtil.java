package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class IsepUtil {

     public static String sha512(String txt){
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
    
        byte[]hash=md.digest(txt.getBytes());
        String hash64=Base64.getEncoder().encodeToString(hash);
        return hash64;
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
        // // TODO Auto-generated catch block
        // e.printStackTrace();
    }
   }
    
}
