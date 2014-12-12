package controllers.swagger;

import play.mvc.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordnik.swagger.core.util.JsonUtil;
import java.io.StringWriter;

public class BaseApiController extends Controller {
	protected static ObjectMapper mapper = JsonUtil.mapper();
	
	public static Result JsonResponse(Object obj) {
		return JsonResponse(obj, 200);
	}

	public static Result JsonResponse(Object obj, int code) {
		StringWriter w = new StringWriter();
		try {
			mapper.writeValue(w, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setCORSheaders();
		return ok(w.toString());
	}
	
	private static void setCORSheaders(){
		response().setContentType("application/json");
		response().setHeader("Access-Control-Allow-Origin", "*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
		response().setHeader("Access-Control-Allow-Headers", "*");

	}
}