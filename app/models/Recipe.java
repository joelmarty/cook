package models;

import play.db.jpa.*;

import java.util.*;
import javax.persistence.*;

@Entity
public class Recipe extends Model {

    @Temporal(TemporalType.DATE)
    public Date date;

    public String title;
    
    @ManyToOne
    public User author;

    @OneToMany
    public List<Ingredient> ingredients;

    public String description;

    @Lob
    public String instructions;
}
