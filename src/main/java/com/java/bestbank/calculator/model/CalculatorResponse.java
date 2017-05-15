package com.java.bestbank.calculator.model;

public class CalculatorResponse {
    public double getCompoundInterest() {
        return compoundInterest;
    }

    public void setCompoundInterest(double compoundInterest) {
        this.compoundInterest = compoundInterest;
    }

    public double getSimpleInterest() {
        return simpleInterest;
    }

    public void setSimpleInterest(double simpleInterest) {
        this.simpleInterest = simpleInterest;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    @Override
    public String toString() {
        return "CalculatorResponse{" +
                "compoundInterest=" + compoundInterest +
                ", simpleInterest=" + simpleInterest +
                '}';
    }

    private double compoundInterest;
    private double simpleInterest;
    private String currency=Currency.USD.name();

}
