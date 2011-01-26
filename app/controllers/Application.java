package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

/**
 * The application class contains all features which are directly tied to the
 * application, but do not need to be authenticated. It's then possible to view
 * all the recipes, and to search through them, for instance.
 */
public class Application extends Controller {

    public static void listRecipes() {
        List<Recipe> recipes = Recipe.findAll();
        renderTemplate("Recipes/list.html", recipes);
    }

    /**
     * List all the recipes for an username
     */
    public static void listUserRecipes(String username){
        // first, get the user from the username
        User user = User.find("byName", username).first();
        if (user == null){
            notFound(username);
        }
        List<Recipe> recipes = Recipe.find("byAuthor", user).fetch();
        renderTemplate("Recipes/list.html", recipes, user);
    }

    /**
     * Show a specific recipe
     */
    public static void show(Long id) {
        Recipe rp = Recipe.findById(id);
        if (rp == null){
            notFound();
        }
        render(rp);
    }

    public static void searchByIngredients(List<Ingredient> ingredients, List<Ingredient> exclude){
    }

    public static void searchByName(String name){
        List<Recipe> recipes = Recipe.find("byTitleLike", "%" + name + "%").fetch();
        render(recipes);
    }

    public static void searchByDate(Date date){
    }

    public static void searchByPeriod(Period period){
    }
}
