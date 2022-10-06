package org.example.비번;

import org.example.비번.PasswordGenerator;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "aaaabbbb"; // 8글자
    }
}
