package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.time.Month;

public class DateTimeApi {
    static final String DATE_FORMAT_PATTERN_FULL = "YYYY-MM-DD";
    static final String DATE_FORMAT_PATTERN_YEAR = "YYYY";
    static final String DATE_FORMAT_PATTERN_MONTH = "MMMM";
    static final String DATE_FORMAT_PATTERN_DAY = "d";
    static final int HOURS_OFFSET_UKRAINE = 2;

    /**
     * Return the current date as a String depending on a query.
     * <p>
     * The query can be passed for the whole date or for it's part:
     * - FULL - current date as a whole: year, month, day of month
     * formatted as `YYYY-MM-DD` (a default return value);
     * - YEAR - current year;
     * - MONTH - name of the current month;
     * - DAY - current day of month;
     * In any other case throw DateTimeException.
     **/
    public String todayDate(DateTimePart datePart) {
        LocalDate currentDate = LocalDate.now();
        if (datePart == DateTimePart.FULL) {
            return currentDate
                    .format(DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN_FULL));
        }
        if (datePart == DateTimePart.YEAR) {
            return currentDate
                    .format(DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN_YEAR));
        }
        if (datePart == DateTimePart.MONTH) {
            return currentDate
                    .format(DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN_MONTH));
        }
        if (datePart == DateTimePart.DAY) {
            return currentDate
                    .format(DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN_DAY));
        }
        throw new DateTimeException("No time defined");
    }

    /**
     * Given an Array of 3 elements, where
     * - 1-st element is a `year`;
     * - 2-nd element is s `month`;
     * - 3-rd element is a `day of month`;
     * <p>
     * Return LocalDate built from these elements. If Array contains more than 3 elements - throw DateTimeException.
     */
    public LocalDate getDate(Integer[] dateParams) {
        if (dateParams.length != 3 || String.valueOf(dateParams[0]).length() < 4) {
            throw new DateTimeException("Invalid date params");
        }
        String dateString = Arrays.stream(dateParams)
                .map(v -> {
                    String string = String.valueOf(v);
                    if (string.length() == 1) {
                        string = "0" + string;
                    }
                    return string;
                })
                .collect(Collectors.joining("-"));
        return Optional.of(LocalDate.parse(dateString))
                .orElseThrow(() -> new DateTimeException("Invalid date params"));
    }

    /**
     * Given the time and the number of hours to add, return the changed time.
     */
    public LocalTime addHours(LocalTime localTime, Integer hoursToAdd) {
        return localTime.plusHours(hoursToAdd);
    }

    /**
     * Given the time and the number of minutes to add, return the changed time.
     */
    public LocalTime addMinutes(LocalTime localTime, Integer minutesToAdd) {
        return localTime.plusMinutes(minutesToAdd);
    }

    /**
     * Given the time and the number of seconds to add, return the changed time.
     */
    public LocalTime addSeconds(LocalTime localTime, Integer secondsToAdd) {
        return localTime.plusSeconds(secondsToAdd);
    }

    /**
     * Given the date and the number of weeks to add, return the changed date.
     */
    public LocalDate addWeeks(LocalDate localDate, Integer numberOfWeeks) {
        return localDate.plusWeeks(numberOfWeeks);
    }

    /**
     * Given a random `someDate` date, return one of the following Strings:
     * - "`someDate` is after `currentDate`"
     * if `someDate` is in the future relating to the `current date`;
     * - "`someDate` is before `currentDate`"
     * if `someDate` is in the past relating to the `current date`;
     * - "`someDate` is today"
     * if `someDate` is today;
     */
    public String beforeOrAfter(LocalDate someDate) {
        LocalDate currentDate = LocalDate.now();
        if (someDate.isAfter(currentDate)) {
            return "`someDate` is after `currentDate`";
        }
        if (someDate.isBefore(currentDate)) {
            return "`someDate` is before `currentDate`";
        }
        return "`someDate` is today";
    }

    /**
     * Given a String representation of a date and some timezone,
     * return LocalDateTime in this timezone.
     */
    public LocalDateTime getDateInSpecificTimeZone(String dateInString, String zone) {
        LocalDateTime parsedTime = LocalDateTime.parse(dateInString.substring(0, dateInString.length() - 1));
        ZoneId searchingZone = ZoneId.of(zone);
        ZoneOffset offset = searchingZone.getRules().getOffset(LocalDateTime.now());
        int secondsOffset = offset.getTotalSeconds();
        return parsedTime.plusSeconds(secondsOffset);
    }

    /**
     * Given some LocalDateTime, return an OffsetDateTime with the local time offset applied
     * (`+02:00` for Ukraine). Note that for Ukraine, the offset could be `+02:00` or `+03:00`, depending on whether daylight saving time is in effect for the provided date and time. So for this task, we assume that in Ukraine we always are using `+02:00` timezone
     * <p>
     * Example: we receive a LocalDateTime with a value `2019-09-06T13:17`.
     * We should return the OffsetDateTime with a value `2019-09-06T13:17+02:00`,
     * where `+02:00` is the offset for our local timezone.
     * <p>
     * OffsetDateTime is recommended to use for storing date values in a database.
     */
    public OffsetDateTime offsetDateTime(LocalDateTime localTime) {
        return localTime.atOffset(ZoneOffset.ofHours(HOURS_OFFSET_UKRAINE));
    }

    /**
     * Given a String formatted as `yyyyMMdd`,
     * return LocalDate object built from this String.
     */
    public LocalDate parseDate(String date) {
        String transformedDateString = date.substring(0, 4)
                + "-" + date.substring(4, 6)
                + "-" + date.substring(6);
        return LocalDate.parse(transformedDateString);
    }

    /**
     * Given a String formatted as `d MMM yyyy` (MMM - Sep, Oct, etc),
     * return LocalDate object built from this String.
     */
    public LocalDate customParseDate(String date) throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("d MMM yyyy");
        Date pardesDate = dateFormatter.parse(date);
        dateFormatter.applyPattern("yyyy-MM-dd");
        return LocalDate.parse(dateFormatter.format(pardesDate));
    }

    public LocalDate customParseDate1(String date) {
        String[] dateParts = date.split(" ");
        String year = dateParts[2];
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);
        String monthValue = String.valueOf(Month.from(parser.parse(dateParts[1])).getValue());
        String month = monthValue.length() == 1 ? "0" + monthValue : monthValue;
        String day = dateParts[0].length() == 1 ? "0" + dateParts[0] : dateParts[0];
        return LocalDate.parse(year + "-" + month + "-" + day);
    }

    /**
     * Given some LocalDateTime, return a String formatted as
     * `day(2-digit) month(full name in English) year(4-digit) hours(24-hour format):minutes`.
     * <p>
     * Example: "01 January 2000 18:00".
     */
    public String formatDate(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm"));
    }
}
