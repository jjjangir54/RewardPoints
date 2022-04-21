package com.jjjangir54.retailerRewards.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jjjangir54.retailerRewards.model.Customer;
import com.jjjangir54.retailerRewards.model.Response;
import com.jjjangir54.retailerRewards.service.RetailerRewardsService;

@RestController
public class RewardPointsController {
	
private List<Customer> customers;
	
	@Autowired
	private RetailerRewardsService retailerRewardsService;
	
	@PostConstruct
	public void createCustomers() {
		customers = new ArrayList<Customer>() {
			{
				for (int i = 1; i <= 100; i++) {
					add(new Customer(i));
				}
			}
		};
	}
	
	@GetMapping(path = "/{customerId}")
	public ResponseEntity<?> getPoints(@PathVariable("customerId") int id) throws Exception{
		try {
			for (Customer customer: customers) {
				if (customer.getCustomerId() == id) {
					int totalPoints = retailerRewardsService.calculateTotalPoints(customer.getCustomerTransactions());
					List<Integer> monthlyPoints = retailerRewardsService.calculateMonthlyPoints(customer.getCustomerTransactions());
					return new ResponseEntity<Response>(new Response(monthlyPoints, totalPoints), HttpStatus.ACCEPTED);
				}
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

}
