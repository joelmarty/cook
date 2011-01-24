package models;

import play.db.jpa.*;

import java.security.MessageDigest;
import java.util.*;
import javax.persistence.*;

@Entity
public class User extends Model{
    public String name;
    public MessageDigest password;
}
