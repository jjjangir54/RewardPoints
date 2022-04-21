package com.jjjangir54.retailerRewards.model;

import lombok.Data;

@Data
public class CustomerTransactions {
	
	double[] transactions = new double[31];
	
	
	/**
	 * randomly generates monthly transactions
	 */
	public CustomerTransactions() {
		for (int i = 0; i < 31; i++) {
			double transaction = Math.random() * (200);
			transaction = transaction * 125.50;
			transaction = Math.round(transaction);
			transaction = transaction / 101;
			transactions[i] =  transaction;
		}
	}

}
