package com.java.bestbank.calculator.core.tests;

import com.java.bestbank.calculator.core.Calculator;
import com.java.bestbank.calculator.core.CalculatorImpl;
import com.java.bestbank.calculator.core.FXCalculator;
import com.java.bestbank.calculator.core.FXCalculatorImpl;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class CalculatorSteps {

    private static final Logger LOGGER = Logger.getLogger(CalculatorSteps.class.getName());
    private final static Calculator calc = new CalculatorImpl();
    private double compountInterest=0.0;
    private double simpleInterst=0.0;

    @Given("^principal is (.+), time is (.+), interestRate is (.+) and numberOfTime is (.+)$")
    public void testCompoundInterestRateReturn(double principal, int time, double interestRate, int numberOfTime) throws Throwable {
        compountInterest=calc.calculateCompundInterestReturn(principal, time, interestRate, numberOfTime);
        LOGGER.info("testCompoundInterestRateReturn - "+compountInterest);

    }

    @Then("^The Compound Interest is (.+)$")
    public void testCompoundInterestRateReturnResult(double expectedResult) throws Throwable {
        LOGGER.info("testCompoundInterestRateReturnResult - "+expectedResult);
        assertEquals(compountInterest, expectedResult, 10);
    }

    @Given("^principal is (\\d+), interestRate is (.+) and numberOfTime is (\\d+)$")
    public void testSimpleInterestRateReturn(double principal, double interestRate, int numberOfTime) throws Throwable {
        simpleInterst=calc.calculateSimpleInterestReturn(principal, interestRate, numberOfTime);
        LOGGER.info("testSimpleInterestRateReturn - "+simpleInterst);
    }

    @Then("^The Simple Interest Return for single currency is (.+)$")
    public void testSimpleInterestRateReturnResult(double expectedResult) throws Throwable {
        LOGGER.info("testSimpleInterestRateReturn - "+simpleInterst);
        assertEquals(simpleInterst, expectedResult, 10);
    }
}