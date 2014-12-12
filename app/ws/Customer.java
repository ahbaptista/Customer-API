package ws;


import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;

import utils.Converter;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import exceptions.BadRequestException;
import global.Messages;


@ApiModel(value = "Customer", description = "Customer representation")
public class Customer implements Comparable<Customer>{
	@ApiModelProperty(required = true)
	private Long id;
	@ApiModelProperty(required = true)
	private String name;
	@ApiModelProperty(required = true)
	private String duetime;
	@ApiModelProperty(required = true)
	private String jointime;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuetime() {
		return duetime;
	}

	public void setDuetime(String duetime) {
		this.duetime = duetime;
	}

	public String getJointime() {
		return jointime;
	}

	public void setJointime(String jointime) {
		this.jointime = jointime;
	}

	public Customer(){}

	@Override
	public int compareTo(Customer other) {
		DateTime myDate = Converter.toISODate(duetime);
		DateTime otherDate = Converter.toISODate(other.getDuetime());
		return myDate.compareTo(otherDate);
	}
	
	public void validateRequest() throws BadRequestException{
		List<String> missingFields;
		if (!(missingFields=validateMissingFields()).isEmpty()) 
			throw new BadRequestException(Messages.CUST_MISS_FIELDS + missingFields.toString());
		
		String msg;
		if ( (msg = validateDate()) != null) 
			throw new BadRequestException(msg);
	}
	
	private List<String> validateMissingFields(){
		List<String> result = new LinkedList<String>();
		if (id == null) result.add("id");
		if (name == null) result.add("name");
		if (duetime == null) result.add("duetime");
		if (jointime == null) result.add("jointime");
		
		return result;
	}
	
	private String validateDate(){
		try{
			Converter.toISODate(jointime);
		}catch(IllegalArgumentException ex){
			return "jointime - " +ex.getMessage();
		}
		
		try{
			Converter.toISODate(duetime);
		}catch(IllegalArgumentException ex){
			return "duetime - " + ex.getMessage();
		}
		
		return null;
	}
	
}