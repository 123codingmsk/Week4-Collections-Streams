package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAdd(){
        assertEquals(5, calc.add(2,3));
    }

    @Test
    public void testSub(){
        assertEquals(6, calc.sub(10,4));
    }

    @Test
    public void testMul(){
        assertEquals(12, calc.mul(6,2));
    }

    @Test
    public void testDiv(){
        assertEquals(2, calc.div(10, 5));
    }

    @Test
    public void testDivByzero(){
        assertThrows(ArithmeticException.class, ()->calc.div(1,0));
    }
}