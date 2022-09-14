package com.lab2;

import java.time.LocalTime;

public class Phone {
    private int id;

    private String firstName;

    private String lastName;

    private String fatherName;

    private int accountNumber;

    private LocalTime townCallsTime;

    private LocalTime longDistanceCallsTime;

    public String toString() {
        return "====================\n" +
                "Номер: " + id + "\n" +
                "Ім'я: " + firstName + "\n" +
                "Прізвище: " + lastName + "\n" +
                "По-батькові: " + fatherName + "\n" +
                "Номер рахунку: " + accountNumber + "\n" +
                "Час міських розмов: " + townCallsTime + "\n" +
                "Час міжміських розмов: " + longDistanceCallsTime + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalTime getTownCallsTime() {
        return townCallsTime;
    }

    public void setTownCallsTime(LocalTime townCallsTime) {
        this.townCallsTime = townCallsTime;
    }

    public LocalTime getLongDistanceCallsTime() {
        return longDistanceCallsTime;
    }

    public void setLongDistanceCallsTime(LocalTime longDistanceCallsTime) {
        this.longDistanceCallsTime = longDistanceCallsTime;
    }
}
