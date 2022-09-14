package com.lab2;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PhoneInteraction {
    private final ArrayList<Phone> _phones;

    public PhoneInteraction(ArrayList<Phone> phones) {
        _phones = phones;
    }

    public ArrayList<Phone> getCalltimesExceedsSpecifiedTime(LocalTime time) {
        return _phones
                .stream()
                .filter(p -> p.getTownCallsTime().isAfter(time))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Phone> getPhonesWhoUsedLongDistanceCalls() {
        return _phones
                .stream()
                .filter(p -> p.getLongDistanceCallsTime().getHour() != 0 &&
                        p.getLongDistanceCallsTime().getMinute() != 0 &&
                        p.getLongDistanceCallsTime().getSecond() != 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Phone> getPhonesByAccountNumberInRange(int an1, int an2) {
        return _phones
                .stream()
                .filter(p -> p.getAccountNumber() > an1 &&
                        p.getAccountNumber() < an2)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
