package models;

import play.db.jpa.*;

import java.util.*;
import javax.persistence.*;

@Entity
public class User extends Model{
    public String name;
    public byte[] password;
}
