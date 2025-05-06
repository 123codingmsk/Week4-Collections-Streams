package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    PasswordValidator pv = new PasswordValidator();
    @Test
    void testpasswordchecker(){

        assertTrue(pv.passwordchecker("Amanoj46728"));
        assertFalse(pv.passwordchecker("Ama2noj"),  "too short");
    }
}