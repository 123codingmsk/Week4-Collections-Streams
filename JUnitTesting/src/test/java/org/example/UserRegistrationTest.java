package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    UserRegistration reg = new UserRegistration();
    @Test
    void validregisterUser() {
        assertTrue(reg.registerUser("MANOJ", "gmail@.com", "manoj"));
    }

    @Test
    void invaliduserReg(){
        assertThrows(IllegalArgumentException.class, ()->reg.registerUser("raghu", "123", "msk470"));
    }
}