package models;

import play.db.jpa.*;

import java.util.*;
import javax.persistence.*;
import play.data.validation.*;

@Entity
public class Recipe extends Model {

    @Required
    @Temporal(TemporalType.DATE)
    public Date date;

    @Required
    public String title;
    
    @Required
    @ManyToOne
    public User author;

    @Required
    @OneToMany
    public List<RecipeIngredient> ingredients;

    @Lob
    public String description;

    @Required
    @Lob
    public String instructions;
}
