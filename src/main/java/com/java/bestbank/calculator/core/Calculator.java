package com.java.bestbank.calculator.core;

public interface Calculator {
	double calculateCompundInterestReturn(double principal, int time, double interestrate, int numberofTime);
	double calculateSimpleInterestReturn(double principal, double interestrate, int numberOfYears);
}