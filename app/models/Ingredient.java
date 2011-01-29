package models;

import play.db.jpa.*;
import play.data.validation.*;

import java.util.*;
import javax.persistence.*;

@Entity
public class Ingredient extends Model {

    @Required
    public String name;

    /**
     * A ingredient can have multiple periods when it grows
     */
    @ManyToMany
    @Column(nullable=true)
    public List<Period> periods;
}

