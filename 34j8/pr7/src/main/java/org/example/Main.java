package org.example;

import java.time.*;

public class Main {
    public static void main(String[] args) {
        // DateTime API

        Duration duration = Duration.ofHours(5); // сукунди, хвилини, години
        Period period = Period.ofYears(10); // дні, тижні, місяці, роки

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.plus(duration));
        System.out.println(now.plus(period));
        System.out.println(now.plus(period).plus(duration));
        System.out.println("=====");
        Duration duration1 = Duration.ofHours(48);
        LocalDateTime couponReleasedAt = LocalDateTime
                .of(LocalDate.now(), LocalTime.of(10, 0));
        boolean isValid = couponReleasedAt.plus(duration1).isAfter(LocalDateTime.now());
        System.out.println(isValid);
    }
}