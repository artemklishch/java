package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("d MMM yyyy");

//        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);
//        Month month = Month.from(parser.parse("Sep"));
//        System.out.println(month.getValue());
//        System.out.println(String.valueOf(month.getValue()));

        DateTimeApi dateTimeApi = new DateTimeApi();
//        System.out.println(dateTimeApi.todayDate(DateTimePart.DAY));
//        System.out.println(dateTimeApi.customParseDate1("1 Sep 2020"));


//        System.out.println(dateTimeApi.getDateInSpecificTimeZone("2020-04-16T15:23:01Z", "Asia/Tokyo"));
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_INSTANT;
//        System.out.println(LocalDateTime.parse("2020-04-16T15:23:01"));


//
//        LocalDateTime time =
//                LocalDateTime.parse("2020-04-16T15:23:01Z", DateTimeFormatter.ofPattern("HH:mm"));
//        System.out.println(time);
//        System.out.println(dateTimeApi.getDateInSpecificTimeZone1("2020-04-16T15:23:01Z", "Asia/Tokyo"));




//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("+yyyy-MM-dd'T'HH:mm:ss'Z'")
//                .withZone(ZoneId.of("UTC"));
//        LocalDateTime date = LocalDateTime.parse("+2017-02-26T01:02:03Z", formatter);
//        LocalDateTime date1 = LocalDateTime.parse("+2020-04-16T15:23:01Z", formatter);
//        System.out.println(date);
//        System.out.println(date1);


        System.out.println(dateTimeApi.getDateInSpecificTimeZone("2020-04-16T15:23:01Z","Asia/Tokyo"));
//        System.out.println(LocalDateTime.parse("2020-04-16T15:23:01").plusHours(9));
        var d = "Heklo";
        System.out.println(d);

    }

}