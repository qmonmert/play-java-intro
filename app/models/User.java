package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

//import javax.persistence.Entity;
//import javax.persistence.Id;

@Entity
public class User { // extends Model {

//    @Id
//    private String id;

    @Id
    private ObjectId id;

    private String login;

    private String password;

    public User(ObjectId id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    //    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
