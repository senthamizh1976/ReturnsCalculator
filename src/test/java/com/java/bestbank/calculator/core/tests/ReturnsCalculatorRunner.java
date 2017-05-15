package com.java.bestbank.calculator.core.tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:cucumber/",
				 glue="com.java.bestbank.calculator.core.tests"
				)
public class ReturnsCalculatorRunner {
}