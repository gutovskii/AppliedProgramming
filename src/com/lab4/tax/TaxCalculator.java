package com.lab4.tax;

import com.lab4.tax.taxes.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TaxCalculator {
    private final ArrayList<Tax> taxes = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final double income;

    public TaxCalculator(double income) {
        this.income = income;
    }

    public void printTaxes() {
        int taxesCount = taxes.size();
        if (taxesCount > 0) {
            for (int i = 0; i < taxes.size(); i++) {
                System.out.println(
                    (i + 1) + ". " + taxes.get(i).toString()
                );
            }
        }
        else System.out.println("===Податків не знайдено===");
    }

    public void addTaxes() {
        addTaxMenu();

        System.out.println("Уведіть податок: ");
        int choose = scanner.nextInt();

        Tax tax;

        switch (choose) {
            case 1 -> {
                tax = new FromTheMainAndAdditionPlacesOfWorkTax(income);
                taxes.add(tax);
            }
            case 2 -> {
                tax = new RoyaltyTax(income);
                taxes.add(tax);
            }
            case 3 -> {
                tax = new PropertySalesTax(income);
                taxes.add(tax);
            }
            case 4 -> {
                tax = new WithholdingTax(income);
                taxes.add(tax);
            }
            case 5 -> {
                tax = new TransferFromAbroadTax(income);
                taxes.add(tax);
            }
            case 6 -> {
                tax = new BenefitsForChildrenTax(income);
                taxes.add(tax);
            }
            case 7 -> {
                tax = new FinancialAidTax(income);
                taxes.add(tax);
            }
        }
    }

    public void deleteTax() {
        System.out.println("Оберіть податок який ви хочете видалити зі списку");
        printTaxes();
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        try {
            taxes.remove(index - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("===Такого податку не існує===");
        } catch (Exception e) {
            System.out.println("===Щось пішло не так===");
        }
    }

    public void searchSumTaxes() {
        double sum = 0;
        for (var tax : taxes) {
            sum += tax.getTaxPrice();
        }
        printTaxes();
        System.out.println("\nСумма всіх податків - " + sum);
    }

    public void sortTaxes() {
        taxes.sort(Comparator.comparing(Tax::getTaxPrice));
        printTaxes();
    }

    public void searchTax() {
        System.out.println(
                """
                        Оберіть тип пошуку:
                        1.Зробити пошук по введеному діапазоні на податок
                        2.Зробити пошук по слові"""
        );
        switch (scanner.nextInt()) {
            case 1 -> {
                int x1, x2;
                System.out.println("Введіть х1: ");
                x1 = scanner.nextInt();
                System.out.println("Введіть х2: ");
                x2 = scanner.nextInt();
                System.out.println();
                var sortedTaxes = taxes.stream().filter(tax -> tax.getTaxPrice() >= x1 && tax.getTaxPrice() <= x2).toList();
                if (sortedTaxes.size() > 0) {
                    for (int i = 0; i < sortedTaxes.size(); i++) {
                        System.out.println((i + 1) + ". " + sortedTaxes.get(i).toString());
                    }
                } else System.out.println("===Податків не знайдено===");
            }
            case 2 -> {
                System.out.println("Введіть слово: ");
                String word = scanner.next();
                System.out.println();
                var sortedTaxes = taxes.stream().filter(tax -> tax.getName().contains(word)).toList();
                if (sortedTaxes.size() > 0) {
                    for (int i = 0; i < sortedTaxes.size(); i++) {
                        System.out.println((i + 1) + ". " + sortedTaxes.get(i).toString());
                    }
                } else System.out.println("===Податків не знайдено===");
            }
        }
    }

    private void addTaxMenu() {
        System.out.println("\nОберіть наступний податок який хочете додати:");
        System.out.println("1.Додати податок з основного або додаткового місця роботи");
        System.out.println("2.Додати податок з авторських винагород");
        System.out.println("3.Додати податок з продажу майна");
        System.out.println("4.Додати податок з отримання грошофих сум або майна");
        System.out.println("5.Додати податок з отримання коштів з-за кордону");
        System.out.println("6.Додати податок з пільг на дітей");
        System.out.println("7.Додати податок з матеріальної допомоги");
        System.out.println("0.Вернутися в попереднє меню");
    }

    public double getIncome() {
        return income;
    }
}
