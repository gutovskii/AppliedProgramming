package com.lab4.tax.taxes;

public abstract class Tax {
    protected final String name;
    protected double percentage;
    protected double income;
    protected double taxPrice;

    public Tax(double income, double percentage, String name) {
        this.name = name;
        this.percentage = percentage;
        this.income = income;
        this.taxPrice = income / 100 * percentage;
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }

    public double getIncome() {
        return income;
    }

    public double getTaxPrice() {
        return taxPrice;
    }

    @Override
    public String toString() {
        return
                "Імя вашого податку='" + name + '\'' +
                ", процент податку =" + percentage +
                ", сума податку =" + taxPrice;
    }
}
