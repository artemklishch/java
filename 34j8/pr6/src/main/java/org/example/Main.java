package org.example;

import java.time.*;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        // DateTime
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone.getDisplayName());
        System.out.println(timeZone.toZoneId());
        System.out.println("=====");
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        System.out.println("=====");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println("====");

        ZonedDateTime australiaTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(ZoneId.SHORT_IDS.get("AET")));
        System.out.println(australiaTime);
        ZoneId aet = ZoneId.of(ZoneId.SHORT_IDS.get("AET"));
        ZoneOffset offset = aet.getRules().getOffset(LocalDateTime.now());
        System.out.println(offset);
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(Instant.now(), offset);
        System.out.println(localDateTime1);
    }
}