/**
 * 
 */
package com.java.bestbank.calculator.core;

import java.util.HashMap;
import java.util.Map;

public class FXCalculatorImpl implements FXCalculator {
	private static final Map<String, Double> xRates = new HashMap<String, Double>(); 
	
	public FXCalculatorImpl() {
		//The below hardcoded information should be retrieved from database or file or cache.
		//Just hard-coded for this solution
		xRates.put("GBP/USD", 1.28864);
		xRates.put("GBP/INR", 82.7989);
		xRates.put("GBP/EUR", 1.17890);		
	}
	
	@Override
	public final double getFXRate(String sourceCurrency, String destCurrency) {
		return xRates.get(sourceCurrency+"/"+destCurrency);
	}
	
	@Override
	public final double calculate(String sourceCurrency, String destCurrency, double amount) {
		double convertedAmount = getFXRate(sourceCurrency, destCurrency) * amount;
		return convertedAmount;
	}
}
