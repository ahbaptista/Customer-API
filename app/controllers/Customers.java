package controllers;

import global.Messages;

import java.util.List;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import services.OrderService;
import utils.Converter;
import ws.Customer;
import actions.ExceptionCatcher;

import com.fasterxml.jackson.databind.JsonNode;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "/customers", description = Messages.CUST_EDP)
@With(ExceptionCatcher.class)
public class Customers extends Controller {

	@ApiOperation(value = Messages.CUST_DESC,
			httpMethod = "POST", nickname =  "order", response = Customer.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "body", value = "Customers List", required = true, dataType = "Array[ws.Customer]", paramType = "body")
	})    
	@ApiResponses({
		@ApiResponse( code = 200, message = Messages.CUST_200),
		@ApiResponse( code = 400, message = Messages.CUST_400),
		@ApiResponse( code = 500, message = Messages.CUST_500)		
	})
	public static Result order() throws Exception{
		JsonNode body = request().body().asJson();
				List<Customer> customers = Converter.jacksonFromJson(body);
		OrderService.order(customers);
		JsonNode result = Json.toJson(customers);
		
		return ok(result);
	}

}