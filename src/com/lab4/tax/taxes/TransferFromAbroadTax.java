package com.lab4.tax.taxes;

public class TransferFromAbroadTax extends Tax {
    public TransferFromAbroadTax(double income) {
        super(income, 25, "Податок із отримання коштів із-за кордону");
    }
}
