package com.behavox.interview.cad.converter.entity;

public class ConvertResponse {

    private double cadAmount;
    private double rate;
    private String targetSymbol;
    private double targetAmount;

    public double getCadAmount() {
        return cadAmount;
    }

    public void setCadAmount(double cadAmount) {
        this.cadAmount = cadAmount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getTargetSymbol() {
        return targetSymbol;
    }

    public void setTargetSymbol(String targetSymbol) {
        this.targetSymbol = targetSymbol;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }
}
