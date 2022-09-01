package com.lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Скільки чисел Люка порахувати?: ");

        int primeNumbers = 0;
        int numbersCount = scanner.nextInt();

        for (int i = 0; i < numbersCount; i++) {
            var lukeNumber = new LukeNumber(i + 1);

            if (isPrime(lukeNumber.getNumber())) {
                System.out.print("(" + lukeNumber.getNumber() + ") ");
                primeNumbers++;
            } else System.out.print(lukeNumber.getNumber() + " ");
        }
        System.out.println("\nУсього простих чисел: " + primeNumbers);
    }

    /** Checks the number is prime
     *
     * @param num number to check
     * @return true if prime, false if not
     */
    private static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= num / 2; i++)
            if ((num % i) == 0) return false;

        return true;
    }
}
