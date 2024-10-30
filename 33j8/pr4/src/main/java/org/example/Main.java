package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        List<Phone> phonesFromDB = getPhonesFromDB();
//        Stream<Phone> stream = phonesFromDB.stream();
//        Stream<Phone> filteredByMarkerAndMemory = stream.filter(p -> p.getMarker().equals("Apple") && p.getMemory() >= 64);
//        filteredByMarkerAndMemory.forEach(p -> System.out.println(p.getModel()));

//        getPhonesFromDB()
//                .stream()
//                .filter(p -> p.getMarker().equals("Apple") && p.getMemory() >= 64)
//                .forEach(p -> System.out.println(p.getModel()));

        List<String> models = getModelsByMemberAndMemory("Apple", 64);
        System.out.println(models);
    }

    private static List<String> getModelsByMemberAndMemory(String maker, double memory) {
        List<String> models = getPhonesFromDB().stream()
                .filter(p -> p.getMarker().equals(maker) && p.getMemory() >= memory) // filters
                .map(Phone::getModel) // transforms data
                .collect(Collectors.toList()); // transform the stream into list
        return models;
    }

    private static List<Phone> getPhonesFromDB() {
        List<Phone> phones = new ArrayList<>();
        Phone.Builder iPhoneBuilder = new Phone.Builder("Apple");
        Phone iPhoneX = iPhoneBuilder.setModel("iPhone X").setMemory(64).setScreenDiagonal(5.8).setBatteryLife(22).build();
        Phone iPhone7 = iPhoneBuilder.setModel("iPhone 7").setMemory(32).setScreenDiagonal(4.7).setBatteryLife(18).build();
        Phone iPhone12 = iPhoneBuilder.setModel("iPhone 12").setMemory(128).setScreenDiagonal(6.1).setBatteryLife(23).build();

        Phone.Builder samsungBuilder = new Phone.Builder("Sumsung");
        Phone samsumgA5 = samsungBuilder.setModel("A5").setMemory(32).setScreenDiagonal(5.2).setBatteryLife(19).build();
        Phone samsumgS20 = samsungBuilder.setModel("S20").setMemory(128).setScreenDiagonal(6.2).setBatteryLife(22).build();

        phones.add(iPhoneX);
        phones.add(iPhone7);
        phones.add(iPhone12);
        phones.add(samsumgA5);
        phones.add(samsumgS20);

        return phones;
    }
}