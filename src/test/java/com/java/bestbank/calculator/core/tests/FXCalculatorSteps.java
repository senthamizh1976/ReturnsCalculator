package com.java.bestbank.calculator.core.tests;

import static org.junit.Assert.assertEquals;
import com.java.bestbank.calculator.core.FXCalculator;
import com.java.bestbank.calculator.core.FXCalculatorImpl;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.logging.Logger;

public class FXCalculatorSteps {

    private static final Logger LOGGER = Logger.getLogger(FXCalculatorSteps.class.getName());
	FXCalculator fxcalc = new FXCalculatorImpl();
	double fxrate = 0.0;
	double targetAmount=0.0;

	//Scenario: Get FX Rate for single currency
	@Given("^sourceCurrency is (.*) and targetCurrency is (.*)$")
	public void testFXRate(String sourceCurrency, String targetCurrency) {
		fxrate = fxcalc.getFXRate(sourceCurrency, targetCurrency);
        LOGGER.info("\ntestFXRate - "+fxrate);
	}

	@Then("^The conversionRate is (.+)$")
	public void conversionRateIs(Double fxresult){
        LOGGER.info("\nconversionRateIs - "+fxresult);
        LOGGER.info("\nconversionRateIs-FX - "+fxrate);
		assertEquals(fxrate, fxresult, 10);
	};

    @Given("^sourceCurrency is (.*), targetCurrency is (.*) and conversionAmount given as (.+)$")
	public void testCalculate(String sourceCurrency, String targetCurrency, Double amount) {
        LOGGER.info("\ntestCalculate - "+amount);
    	targetAmount = fxcalc.calculate(sourceCurrency, targetCurrency, amount);
        LOGGER.info("\ntestCalculate-targetAmount- "+targetAmount);
	}
    
	@Then("^result must be (.+)$")
	public void convertedAmountIs(Double destAmount){
        LOGGER.info("\nconvertedAmountIs- "+destAmount);
		assertEquals(destAmount, targetAmount, 10);
	};
}
