package com.lab4.command;

import com.lab4.tax.TaxCalculator;

import java.util.ArrayList;

public class CommandExecutor {
    private final ArrayList<Command> commands = new ArrayList<>();
    private final TaxCalculator taxCalculator;

    public CommandExecutor(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
        addCommands();
    }

    private void addCommands() {
        commands.add(new PrintTaxesCommand(taxCalculator));
        commands.add(new AddTaxCommand(taxCalculator));
        commands.add(new DeleteTaxCommand(taxCalculator));
        commands.add(new SearchSumTaxesCommand(taxCalculator));
        commands.add(new SortTaxesCommand(taxCalculator));
        commands.add(new SearchTaxCommand(taxCalculator));
    }

    public void executeCommand(int i) {
        commands.get(i - 1).execute();
    }
}
