package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void show(Long id) {
        Recipe rp = Recipe.findById(id);
        render(rp);
    }

}
