package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.admin;

/**
 * Created by Quentin on 01/02/15.
 */
public class AdminController extends Controller {

    public static Result index() {
        return ok(admin.render());
    }

}
