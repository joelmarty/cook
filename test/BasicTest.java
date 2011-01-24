import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;
import java.security.*;
import java.io.UnsupportedEncodingException;

public class BasicTest extends UnitTest {

    @Test
    public void addUser() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String password = "bob";
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        User us = new User();
        us.name = "bob";
        us.password = md5.digest(password.getBytes("UTF-8"));
        us.save();

        List<User> users = User.findAll();
        assert users.size() > 0 : "User wasn't saved";
    }

    @Test
    public void addPeriod() {
        Period pr = new Period();
        pr.name = "always";

        pr.save();

        List<Period> items = Period.findAll();
        assert items.size() > 0 : "Period wasn't saved";
    }

    @Test
    public void addIngredient() {
        Ingredient ing = new Ingredient();
        ing.name = "pasta";
        
        ing.save();

        List<Ingredient> items = Ingredient.findAll();
        assert items.size() > 0 : "Ingredient wasn't saved";
    }

    @Test
    public void addRecipe() {
        List<User> us = User.findAll();
        List<Ingredient> ing = Ingredient.findAll();

        Recipe rp = new Recipe();
        rp.title = "pasta";
        rp.date = new Date();
        rp.author = us.get(0);
        rp.ingredients = ing;
        rp.description = "a fabulous pasta meal";
        rp.instructions = "cook pasta, add stuff and it's ready! yummy!";

        rp.save();

        List<Recipe> items = Recipe.findAll();
        assert items.size() > 0 : "Recipe wasn't saved";
    }
}
