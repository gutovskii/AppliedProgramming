package com.lab4.command;

import com.lab4.tax.TaxCalculator;

public class DeleteTaxCommand implements Command {
    private final TaxCalculator taxCalculator;

    public DeleteTaxCommand(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public void execute() {
        taxCalculator.deleteTax();
    }
}
