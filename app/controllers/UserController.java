package controllers;

import models.User;
import org.mongodb.morphia.Datastore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.MongoHelper;

import java.util.List;

/**
 * Created by Quentin on 31/01/15.
 */
public class UserController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private static Datastore datastore = MongoHelper.getDatastore();

    public static Result getUsers() {
        //List<User> users = new Model.Finder(String.class, User.class).all();
        List<User> users = datastore.find(User.class).asList();
        logger.info("Get all users");
        return ok(Json.toJson(users));
    }

    public static Result addUser() {
        User user = Form.form(User.class).bindFromRequest().get();
        //user.save();
        datastore.save(user);
        logger.info("User added");
        logger.info("User added login    : " + user.getLogin());
        logger.info("User added password : " + user.getPassword());
        return redirect(controllers.routes.AdminController.index());
    }

}
