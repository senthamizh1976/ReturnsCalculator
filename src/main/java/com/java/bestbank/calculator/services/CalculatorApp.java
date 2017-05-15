package com.java.bestbank.calculator.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.java.bestbank.calculator"})
public class CalculatorApp {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorApp.class, args);
    }
}
