package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    TemperatureConverter temp = new TemperatureConverter();
    @Test
    void testFah(){
        assertEquals(118.4,temp.celsiusToFahrenheit(48));
        assertNotEquals(120,temp.celsiusToFahrenheit(48), "not correct");
    }

    @Test
    void testCel(){
        assertEquals(48, temp.fahrenheitToCelsius(118.4));
        assertNotEquals(50, temp.fahrenheitToCelsius(118.4));
    }

}