package utils;


import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import play.libs.Json;
import ws.Customer;

import com.fasterxml.jackson.databind.JsonNode;

import exceptions.BadRequestException;


public class Converter{
	private static final FastDateFormat isoFormatter = 
			DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT;
	
	public static DateTime toISODate(String date){
		DateTimeFormatter f = DateTimeFormat.forPattern(isoFormatter.getPattern());
		return f.withOffsetParsed().parseDateTime(date);
	}
	
	public static String fromISODate(DateTime date){
		return isoFormatter.format(date);
	}
	
	public static List<Customer> jacksonFromJson(JsonNode json) throws BadRequestException{
		List<Customer> result = new LinkedList<Customer>();
		for (JsonNode item : json){
			Customer c = null;
			c = Json.fromJson(item, Customer.class);
			c.validateRequest();
			result.add(c);
		}
		return result;
	}
	
}