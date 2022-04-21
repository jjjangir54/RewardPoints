# RewardPoints Calculation (Maven)
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.
  
  -> Make up a data set to best demonstrate your solution
  -> Check solution into GitHub

# Required Build Dependencies

1.Java 1.8

2.Lombok

3.Devtools

4.Maven


## Instructions for running the project on a local machine :
http://localhost:8080/{customerId}


**Note**: customerId range from 1 to 100 for this application.
Output for customerId beyond the range : **NOT_FOUND**
Output for bad input : **Bad Request**
