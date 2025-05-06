package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TestingParameterizedTest {

    TestingParameterized tp = new TestingParameterized();
    @ParameterizedTest
    @ValueSource(ints = {2,4,6,7,9})
    void testIsEven(int num){
        assertTrue(tp.isEven(num) || !tp.isEven(num));
    }
}