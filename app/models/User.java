package models;

import play.db.jpa.*;
import play.Logger;
import play.data.validation.*;

import java.util.*;
import java.lang.*;
import javax.persistence.*;
import java.security.*;
import models.exceptions.*;

@Entity
@Table(name="Users")
public class User extends Model{
    
    @Required
    public String name;

    @Email
    @Required
    public String email;

    @Required
    public String password;

    /**
     * Create an user given the provided informations.
     *
     * The password must be the uncyphered, and will be cyphered by this
     * method.
     */
    public static User create(String name, String email, String password){
        User user = new User();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            user.name = name;
            user.email = email;
            user.password = Utils.getHexString(md5.digest(password.getBytes("UTF-8")));
            user.save();

        } catch (Exception e) {
            Logger.error(e.getMessage());
        }

        return user;
    }

    /**
     * Return true if no user is registered with this username
     */
    public static boolean isNameAvailable(String name){
        return User.count("name = ?", name) == 0;
    }

    /**
     * Return true if no user with this email is already registred
     */
    public static boolean isEmailAvailable(String email){
        return User.count("email = ?", email) == 0;
    }

    /**
     * Return an user if the login informations (name and password) matches,
     * otherwise, throws a WrongCredentials exception.
     */
    public static User getUser(String name, String password) throws WrongCredentials{
        // convert the password to md5
        User user = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String digest = Utils.getHexString(md5.digest(password.getBytes("UTF-8")));
            List<User> users = User.find("name = % and password = %", name, digest).fetch();
            user = users.get(0);
        } catch (IndexOutOfBoundsException e){
            throw new WrongCredentials(); // if no user is returned, throw an exception
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }
        return user;
    }
}
