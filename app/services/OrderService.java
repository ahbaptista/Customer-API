package services;

import java.util.Collections;
import java.util.List;
import ws.Customer;
public class OrderService{
	public static List<Customer> order(List<Customer> customers){
		Collections.sort(customers);
		return customers;		
	}
}