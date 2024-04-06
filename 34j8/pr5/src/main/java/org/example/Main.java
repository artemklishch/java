package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // DateTime API
        // LocalDate
        // LocalTime
        // LocalDateTime

        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);
        System.out.println(currentDate.plusDays(4)); // doesn't changes the start date
        System.out.println(currentDate.plusYears(4));
        System.out.println(currentDate.format(DateTimeFormatter.ofPattern("dd-yyyy-MM")));
        LocalDate parsed = LocalDate.parse("2020-11-22");
        System.out.println(parsed);
        System.out.println(parsed.getYear());
        System.out.println(parsed.getEra());
        System.out.println(parsed.getMonth());
        System.out.println(parsed.getMonth().getValue());
        System.out.println(parsed.getDayOfMonth());
        System.out.println("======");
        LocalDateTime currentDate1 = LocalDateTime.now();
        System.out.println(currentDate1);
        System.out.println(currentDate1.plusDays(4)); // doesn't changes the start date
        System.out.println(currentDate1.plusYears(4));
        System.out.println(currentDate1.format(DateTimeFormatter.ofPattern("dd-yyyy-MM HH:mm")));
        System.out.println(currentDate1.toLocalTime());
        System.out.println("======");
        System.out.println("======");
    }
}