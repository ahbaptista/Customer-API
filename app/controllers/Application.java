package controllers;

import controllers.swagger.BaseApiController;
import play.mvc.Result;

public class Application extends BaseApiController {

	public static Result docs() {
		return redirect("/assets/api-docs/index.html");
	}
}
