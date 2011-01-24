package controllers;

import models.User;
import java.security.*;
import java.io.UnsupportedEncodingException;
import play.Logger;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        MessageDigest md5 = null;
        byte[] hash = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            hash = md5.digest(password.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            Logger.error(e, "Oops!");
        } catch (UnsupportedEncodingException e) {
            Logger.error(e, "Oops!");
        }

        
        User user = User.find("byName", username).first();

        return user != null && user.password.equals(hash);
    }

}
