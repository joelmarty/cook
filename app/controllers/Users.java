package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Users extends Controller {

    public static void signup() {
        render();
    }

    public static void process_signup(
            @Required String username, 
            @Required @MinSize(10) @Equals("password_confirmation") String password, 
            @Required String password_confirmation, 
            @Email String email){

        // Check that the user do not already exists.   
        if (!User.isNameAvailable(username)){
            Validation.addError("username", "already taken !");
        }

        // Check that the email adress is not already used.
        if (!User.isEmailAvailable(email)){
            Validation.addError("email", "this email is already in use");
        }

        if (validation.hasErrors()) {
            params.flash();
            validation.keep();
            signup();
        }

        User.Create(username, email, password);
    }

    public static void login(){
        render();
    }
    public static void process_login(@Required String username, @Required String password){

    }

}
