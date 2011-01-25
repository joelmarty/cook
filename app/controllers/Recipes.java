package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Recipes extends Controller {

    public static void list() {
        String user = Security.connected();
        render(user);
    }

    public static void show(Long id) {
        Recipe rp = Recipe.findById(id);
        if (rp == null){
            notFound();
        }
        render(rp);
    }

    public static void create(){
        render();
    }

    // FIXME add the parameters with the validation here
    public static void process_create(){
    }

    public static void search_by_ingredients(List<Ingredient> ingredients, List<Ingredient> exclude){
    }

    public static void search_by_name(String name){
    }

    public static void search_by_user(String username){
    }

    public static void search_by_date(Date date){
    }

    public static void search_by_period(Period period){
    }
}
