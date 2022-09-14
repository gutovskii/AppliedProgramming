package com.lab2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UserInteraction userInteraction = new UserInteraction();
        ArrayList<Phone> phones = userInteraction.getPhonesData();
        for (Phone phone : phones) {
            System.out.println(phone);
        }
        userInteraction.chooseTasks(phones);
    }
}
