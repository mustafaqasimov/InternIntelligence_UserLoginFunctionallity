package az.Security_Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {

    public static String hashedpassword(String password){
        try {
            MessageDigest mD = MessageDigest.getInstance("SHA-256");
            mD.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] digest = mD.digest();

            StringBuilder sB = new StringBuilder();
            for (byte b: digest){
                sB.append(String.format("%02x",b));
            }
            return sB.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing error"+ e);
        }
    }
}
