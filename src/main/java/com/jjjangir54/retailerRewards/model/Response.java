package com.jjjangir54.retailerRewards.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
	
	private List<Integer> monthlyPoints;
	private int totalPoints;

}
