package ws;

import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "ErrorResponse", description = "Error Response representation")
public class ErrorResponse{
	private String reason;
	
	public ErrorResponse(String reason){
		this.reason = reason;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}