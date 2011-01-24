package models;

import play.db.jpa.*;
import play.Logger;

import java.util.*;
import javax.persistence.*;
import java.security.*;

@Entity
public class User extends Model{
    public String name;
    public String email;
    public byte[] password;

    /**
     * Create an user given the provided informations.
     *
     * The password must be the uncyphered, and will be cyphered by this
     * method.
     */
    public static User Create(String name, String email, String password){
        User user = new User();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            user.name = name;
            user.email = email;
            user.password = md5.digest(password.getBytes("UTF-8"));
            user.save();

        } catch (Exception e) {
            Logger.error(e.getMessage());
        }

        return user;
    }
}
