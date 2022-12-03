package com.lab4.command;

import com.lab4.tax.TaxCalculator;

public class SortTaxesCommand implements Command {
    private final TaxCalculator taxCalculator;

    public SortTaxesCommand(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public void execute() {
        taxCalculator.sortTaxes();
    }
}
