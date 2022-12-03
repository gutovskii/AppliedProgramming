package com.lab4.command;

import com.lab4.tax.TaxCalculator;

public class SearchSumTaxesCommand implements Command {
    private final TaxCalculator taxCalculator;

    public SearchSumTaxesCommand(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public void execute() {
        taxCalculator.searchSumTaxes();
    }
}
