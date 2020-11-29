package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formatter {

    public static LocalDate localDateFromString(String localdate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(localdate, dateTimeFormatter);
    }
}
