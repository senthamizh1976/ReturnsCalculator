package com.java.bestbank.calculator.core;

public interface FXCalculator {
	double calculate(String sourceCurrency, String destCurrency, double amount);
	public double getFXRate(String sourceCurrency, String destCurrency);
}
