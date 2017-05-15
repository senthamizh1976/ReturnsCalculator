/**
 * 
 */
package com.java.bestbank.calculator.core;

import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * @author sachinvarsha
 *
 */
public class CalculatorImpl implements Calculator {

	@Override
	public double calculateCompundInterestReturn(double principal, int time, double interestrate, int numberofTime) {
        double amount = principal * Math.pow(1 + (interestrate / numberofTime), numberofTime * time);
        double interest = amount - principal;
		return interest;
	}

	@Override
	public double calculateSimpleInterestReturn(double principal, double interestrate, int numberOfYears) {
		double simpleInterest=principal * interestrate * numberOfYears;
		return simpleInterest;
	}	
	
}


