package com.jjjangir54.retailerRewards.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jjjangir54.retailerRewards.model.CustomerTransactions;

@Service
public class RetailerRewardsService {
	
	/**
	 * Calculates total number of points for all months
	 * */
	public int calculateTotalPoints(List<CustomerTransactions> customerTransactions) {
		return calculateMonthlyPoints(customerTransactions).stream().reduce(0, (i,j) -> i + j);
	}
	
	/**
	 * Calculates total number of points per month and return a list
	 */
	public List<Integer> calculateMonthlyPoints(List<CustomerTransactions> customerTransactions) {
		List<Integer> monthlyPoints = new ArrayList<>();
		for (CustomerTransactions customerTransaction : customerTransactions) {
			int rewardPoints = 0;
			for (double transaction: customerTransaction.getTransactions()) {
				if (transaction > 100) {
					rewardPoints = (int) (50 + 2*(transaction -100));
					//rewardPoints = (2 * (transaction - 100) + 50);
				}
				else if (transaction > 100) {
					rewardPoints += transaction - 50;
				}
				else rewardPoints = 0;
			}
			monthlyPoints.add(rewardPoints);
		}
		return monthlyPoints;
	}

}
