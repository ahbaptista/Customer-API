package actions;

import exceptions.BadRequestException;
import global.Messages;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Action.Simple;
import play.mvc.Http.Context;
import play.mvc.Result;
import ws.ErrorResponse;

public class ExceptionCatcher extends Simple {

	@Override
	public Promise<Result> call(Context ctx) throws Throwable {
		try { 	
			return delegate.call(ctx);
		}
	    catch (BadRequestException ex) {
			return Promise.<Result>pure(badRequest(Json.toJson(new ErrorResponse(ex.getMessage()))));
	    }catch (RuntimeException ex){
	    	return Promise.<Result>pure(badRequest(Json.toJson(new ErrorResponse(ex.getCause().getMessage()))));
	    }catch (Exception ex){
	    	return Promise.<Result>pure(internalServerError(Messages.CUST_500 + ex.getCause().getMessage()));
	    }
		
	}
}
