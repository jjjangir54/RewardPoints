package com.jjjangir54.retailerRewards.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;

@Data
public class Customer {
	
Logger logger = LoggerFactory.getLogger(Customer.class);
	
	private int customerId;
	
	
	List<CustomerTransactions> customerTransactions = new ArrayList<CustomerTransactions>() {
		{
			// initializes three monthly transactions
			add(new CustomerTransactions());
			add(new CustomerTransactions());
			add(new CustomerTransactions());
		}
	};
	
	public Customer(int customerId) {
		this.customerId = customerId;
		logger.info("USER {}", customerId);
		customerTransactions.forEach(customerTransactions -> System.out.println(Arrays.toString(customerTransactions.getTransactions())));
	}
}
