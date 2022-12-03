package com.lab4.tax.taxes;

public class WithholdingTax extends Tax {
    public WithholdingTax(double income) {
        super(income, 15, "Податок із отримання грошових сум або майна");
    }
}
