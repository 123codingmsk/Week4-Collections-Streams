package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TestingDateFormatter {
    public String formatDate(String inputdate) throws DateTimeParseException {
        DateTimeFormatter inpformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter opformat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = LocalDate.parse(inputdate, inpformat);
        return date.format(opformat);
    }
}
