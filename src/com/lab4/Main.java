package com.lab4;

import com.lab4.command.*;
import com.lab4.login.Login;
import com.lab4.tax.TaxCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new Login().startLogging();

        System.out.println("Уведіть ваш щомісячний дохід: ");
        double income = scanner.nextDouble();
        var taxCalculator = new TaxCalculator(income);

        while(true) {
            printMainMenu();
            int choose = scanner.nextInt();
            var commandExecutor = new CommandExecutor(taxCalculator);
            if (choose == 0) break;
            commandExecutor.executeCommand(choose);
        }
    }

    static private void printMainMenu() {
        System.out.println("\n\nОберіть наступну дію:");
        System.out.println("1.Переглянути список податків");
        System.out.println("2.Додати новий податок в список");
        System.out.println("3.Видалити зі списка податок");
        System.out.println("4.Визначити суму податків");
        System.out.println("5.Відсортувати податки");
        System.out.println("6.Вивести податки лише з певною категорією");
        System.out.println("0.Вихід з програми");
    }
}
