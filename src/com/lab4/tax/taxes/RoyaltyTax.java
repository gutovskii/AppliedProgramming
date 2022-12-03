package com.lab4.tax.taxes;

public class RoyaltyTax extends Tax {
    public RoyaltyTax(double income) {
        super(income, 10, "Податок із авторських винагород");
    }
}
