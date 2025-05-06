package org.example;

public class UserRegistration {
    public boolean registerUser(String username, String email, String password) {
        if(!email.contains("@")){
            throw new IllegalArgumentException("Invalid email");
        }
        return true;
    }
}
