package models;

import play.db.jpa.*;

import java.util.*;
import javax.persistence.*;

@Entity
public class Period extends Model{

    @Column(nullable=true)
    public String name;

    @Temporal(TemporalType.DATE)
    public Date start_date;

    @Temporal(TemporalType.DATE)
    public Date end_date;
}

