package com.lab4.command;

import com.lab4.tax.TaxCalculator;

public class SearchTaxCommand implements Command {
    private final TaxCalculator taxCalculator;

    public SearchTaxCommand(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public void execute() {
        taxCalculator.searchTax();
    }
}
