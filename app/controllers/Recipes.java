package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Recipes extends Controller {

    public static void listMine(){
        String username = Security.connected();
        Application.listUserRecipes(username);
    }

    public static void show(Long id) {
        Recipe recipe = Recipe.findById(id);
        if (recipe == null){
            notFound();
        }
        render(recipe);
    }

    public static void create(){
        render();
    }

    // FIXME add the parameters with the validation here
    public static void processCreate(){
    }
}
