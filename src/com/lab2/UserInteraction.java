package com.lab2;

import java.text.MessageFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInteraction {
    public ArrayList<Phone> getPhonesData() {
        ArrayList<Phone> phones = new ArrayList<>();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (true) {
            Phone newPhone = new Phone();

            System.out.println(MessageFormat.format("=====Абонент №{0}=====", i + 1));
            newPhone.setId(i + 1);

            System.out.print("Ім'я: ");
            String firstName = scanner.nextLine();
            if (firstName.equals("")) break;
            newPhone.setFirstName(firstName);

            System.out.print("Прізвище: ");
            String lastName = scanner.nextLine();
            newPhone.setLastName(lastName);

            System.out.print("По-батькові: ");
            String fatherName = scanner.nextLine();
            newPhone.setFatherName(fatherName);

            System.out.print("Номер рахунку: ");
            int accountNumber = Integer.parseInt(scanner.nextLine());
            newPhone.setAccountNumber(accountNumber);

            System.out.print("Час міських розмов: ");
            String townCallsTime = scanner.nextLine();
            newPhone.setTownCallsTime(LocalTime.parse(townCallsTime, timeFormatter));

            System.out.print("Час міжміських розмов: ");
            String longDistanceCallsTime = scanner.nextLine();
            newPhone.setLongDistanceCallsTime(LocalTime.parse(longDistanceCallsTime, timeFormatter));

            phones.add(newPhone);
            i++;
        }
        return phones;
    }

    public void chooseTasks(ArrayList<Phone> phones) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        PhoneInteraction phoneInteraction = new PhoneInteraction(phones);
        ArrayList<Phone> filteredPhones;

        while (true) {
            System.out.println("1: Абоненти, у яких час міських розмов перевищує заданий");
            System.out.println("2: Абоненти, які користувались міжміським зв'язком");
            System.out.println("3: Абоненти, чиї номера рахунку знаходиться у вказаному діапазоні");
            int taskNumber = Integer.parseInt(scanner.nextLine());
            switch (taskNumber) {
                case 1:
                    System.out.print("Уведіть час: ");
                    String timeToFilter = scanner.nextLine();
                    LocalTime localTimeToFilter = LocalTime.parse(timeToFilter, timeFormatter);
                    filteredPhones = phoneInteraction.getCalltimesExceedsSpecifiedTime(localTimeToFilter);
                    System.out.println(filteredPhones);
                    break;
                case 2:
                    filteredPhones = phoneInteraction.getPhonesWhoUsedLongDistanceCalls();
                    System.out.println(filteredPhones);
                    break;
                case 3:
                    System.out.print("Від: ");
                    int an1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("До: ");
                    int an2 = Integer.parseInt(scanner.nextLine());
                    filteredPhones = phoneInteraction.getPhonesByAccountNumberInRange(an1, an2);
                    System.out.println(filteredPhones);
                    break;
                default:
                    return;
            }
        }
    }
}
