package com.lab4.command;

import com.lab4.tax.TaxCalculator;

public class AddTaxCommand implements Command {
    private final TaxCalculator taxCalculator;

    public AddTaxCommand(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public void execute() {
        taxCalculator.addTaxes();
    }
}
