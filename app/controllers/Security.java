package controllers;

import java.security.*;
import java.io.UnsupportedEncodingException;

import models.User;
import models.exceptions.*;

import play.Logger;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        boolean result = true;
        try{
            User.getUser(username, password);
        } catch(WrongCredentials e) {
            result = false;
        }
        return result;
    }
}
