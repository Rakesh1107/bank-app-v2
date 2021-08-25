package test;

import java.util.Map;

import cache.Cache;
import exception.BankException;
import logic.Initiator;
import pojo.Customer;

public class TestRunner {
	
	public static void main(String[] args) {
		Initiator initiator = Initiator.INSTANCE;
		try {
			initiator.initiate();
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		Cache cache = Cache.INSTANCE;
		Map<Integer, Customer> customers = cache.getUsers();
		
		for (Customer customer: customers.values()) {
			System.out.println(customer);
		}
	}

}
