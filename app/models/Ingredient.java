package models;

import play.db.jpa.*;

import java.util.*;
import javax.persistence.*;

@Entity
public class Ingredient extends Model {

    public String name;

    /**
     * A ingredient can have multiple periods when it grows
     */
    @ManyToMany
    public List<Period> periods;
}

