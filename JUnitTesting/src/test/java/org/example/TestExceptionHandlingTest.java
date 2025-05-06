package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestExceptionHandlingTest {
    TestExceptionHandling teh = new TestExceptionHandling();
    @Test
    public void testDivide(){
        assertThrows(ArithmeticException.class, ()->teh.divide(1,0));
    }
}