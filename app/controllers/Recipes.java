package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Recipes extends Controller {

    public static void list() {
        render();
    }

    public static void show(Long id) {
        Recipe rp = Recipe.findById(id);
        if (rp == null){
            notFound();
        }
        render(rp);
    }

}
