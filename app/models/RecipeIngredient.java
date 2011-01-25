package models;

import play.db.jpa.*;

import java.util.*;
import javax.persistence.*;

@Entity
public class RecipeIngredient extends Model {

    public String quantity;

    @ManyToOne(cascade=CascadeType.ALL)
    public Ingredient ingredient;
}


