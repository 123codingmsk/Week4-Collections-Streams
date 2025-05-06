package org.example;

public class TestExceptionHandling {

    public int divide(int a, int b){
        if(b == 0){
            throw new ArithmeticException("Cant divide by zero");
        }
        return a/b;
    }
}
