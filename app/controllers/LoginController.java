package controllers;

import models.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.MongoHelper;

/**
 * Created by Quentin on 01/02/15.
 */
public class LoginController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private static Datastore datastore = MongoHelper.getDatastore();

    public static Result login() {
        User user = Form.form(User.class).bindFromRequest().get();
        Query q = datastore.find(User.class).filter("login", user.getLogin()).filter("password", user.getPassword());
        User userLogged = (User) q.get();
        if (userLogged != null) {
            logger.info("User logged");
            logger.info("User logged login    : " + userLogged.getLogin());
            logger.info("User logged password : " + userLogged.getPassword());
            return redirect(controllers.routes.AdminController.index());
        } else {
            logger.info("User unknown");
            logger.info("User unknown login    : " + user.getLogin());
            logger.info("User unknown password : " + user.getPassword());
            return redirect(controllers.routes.Application.index());
        }
    }

}
