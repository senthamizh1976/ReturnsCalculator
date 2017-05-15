package com.java.bestbank.calculator.model;

public class CalculatorRequest {
    public CalculatorRequest(ReturnsCalculatorBean calculatorBean) {
        this.calculatorBean = calculatorBean;
    }

    public ReturnsCalculatorBean getCalculatorBean() {
        return calculatorBean;
    }

    @Override
    public String toString() {
        return "CalculatorRequest{" +
                "calculatorBean=" + calculatorBean +
                '}';
    }

    public void setCalculatorBean(ReturnsCalculatorBean calculatorBean) {
        this.calculatorBean = calculatorBean;
    }

    private ReturnsCalculatorBean calculatorBean=null;
}
