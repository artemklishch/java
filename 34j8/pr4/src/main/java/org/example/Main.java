package org.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // DateTime API
        // old approaches

        // java.util.Date;
        // java.util.Calendar
        // external library (joda-time)

        Date date = new Date();
        // disadvantages: 1) to fetch formatted date we should use extra SimpleDateFormat class; 2) impossible to update the date
        System.out.println(date);
        System.out.println(date.getTime());
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println(simpleDateFormat.format(date));

        System.out.println("=======");

        Calendar calendar = Calendar.getInstance();
        // disadvantages:
        // 1) no readable format;
        // 2) to fetch formatted date we should use extra SimpleDateFormat class;
        // 3) we should work intuitively, just guess to define the field
        // 4) using 'Calendar. ...' ways resolves, but has a fiew options
        System.out.println(calendar);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(simpleDateFormat1.format(calendar.getTime()));
        calendar.add(Calendar.HOUR, 3); // first argument is the place of some field,  very bed way!!!!
        System.out.println(simpleDateFormat1.format(calendar.getTime()));
        System.out.println(calendar.get(Calendar.HOUR));

        System.out.println("=======");

    }
}