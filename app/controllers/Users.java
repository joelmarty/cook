package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Users extends Controller {

    public static void display_signup_form() {
        render();
    }

    public static void process_signup_form(
            @Required String username, 
            @Required @MinSize(10) @Equals("password_confirmation") String password, 
            @Required String password_confirmation, 
            @Email String email){

        // Check that the user do not already exists.   
        if (User.count("name = ?", username) > 0){
            Validation.addError("username", "already taken !");
        }

        // Check that the email adress is not already used.
        if (User.count("email = ?", email) > 0){
            Validation.addError("email", "this email is already in use");
        }

        if (validation.hasErrors()) {
            params.flash();
            validation.keep();
            display_signup_form();
        }

        User.Create(username, email, password);
    }

}
