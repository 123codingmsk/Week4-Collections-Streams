package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testDeposit(){
        BankAccount acc = new BankAccount();
        assertTrue(acc.deposit(2000));
        assertEquals(2000, acc.getBalance());

        assertFalse(acc.deposit(-500));
        assertEquals(2000, acc.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount acc = new BankAccount();
        acc.deposit(1000);

        assertTrue(acc.withdraw(300));
        assertEquals(700, acc.getBalance());

        assertFalse(acc.withdraw(1000));
        assertEquals(700, acc.getBalance());
    }
}