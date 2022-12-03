package com.lab4.tax.taxes;

public class FinancialAidTax extends Tax {
    public FinancialAidTax(double income) {
        super(income, 5, "Податок із отримання матеріальної допомоги");
    }
}
