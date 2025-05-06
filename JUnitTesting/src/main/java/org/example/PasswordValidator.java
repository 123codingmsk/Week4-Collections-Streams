package org.example;

import java.util.regex.Pattern;

public class PasswordValidator {

    public boolean passwordchecker(String inp){

        String regex = "(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]{8,}";
        return Pattern.matches(regex, inp);
    }
}
