package com.java.bestbank.calculator.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReturnsCalculatorBean {
    private double principal;
    private int time;
    private double interestrate;
    private int numberofTime;

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(double interestrate) {
        this.interestrate = interestrate;
    }

    public int getNumberofTime() {
        return numberofTime;
    }

    public void setNumberofTime(int numberofTime) {
        this.numberofTime = numberofTime;
    }

    public ReturnsCalculatorBean(double principal, int time, double interestrate, int numberofTime) {
        this.principal = principal;
        this.time = time;
        this.interestrate = interestrate;
        this.numberofTime = numberofTime;
    }

    @Override
    public String toString() {
        return "ReturnsCalculatorBean{" +
                "principal=" + principal +
                ", time=" + time +
                ", interestrate=" + interestrate +
                ", numberofTime=" + numberofTime +
                '}';
    }

}

