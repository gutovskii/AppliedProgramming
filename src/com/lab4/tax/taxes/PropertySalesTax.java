package com.lab4.tax.taxes;

public class PropertySalesTax extends Tax {
    public PropertySalesTax(double income) {
        super(income, 18, "Податок із продажу майна");
    }
}
