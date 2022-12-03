package com.lab4.command;

import com.lab4.tax.TaxCalculator;

public class PrintTaxesCommand implements Command {
    private final TaxCalculator taxCalculator;

    public PrintTaxesCommand(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public void execute() {
        taxCalculator.printTaxes();
    }
}
