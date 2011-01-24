package controllers;

import models.User;
import java.security.MessageDigest;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.reset;
        byte[] hash = md5.digest(password.getBytes("UTF-8"));
        
        User user = User.find("byName", username).first();

        return user != null && user.password.equals(hash);
    }

}
