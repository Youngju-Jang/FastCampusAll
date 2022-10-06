package org.example.비번;

import org.example.비번.PasswordGenerator;

public class WrongFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "aa"; // 2글자
    }
}
