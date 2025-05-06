package org.example;

import org.junit.jupiter.api.Test;
import java.time.format.DateTimeParseException;
import static org.junit.jupiter.api.Assertions.*;

class TestingDateFormatterTest {

    TestingDateFormatter test = new TestingDateFormatter();
    @Test
    void formatDate() {
        assertEquals("06-05-2025",test.formatDate("2025-05-06"));
    }

    @Test
    void invalidFormat(){
        assertThrows(DateTimeParseException.class, ()->test.formatDate("05-06-2025"));
    }
}