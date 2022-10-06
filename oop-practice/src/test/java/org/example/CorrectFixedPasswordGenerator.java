package org.example;

public class CorrectFixedPasswordGenerator implements PasswordGenerator{

    @Override
    public String generatePassword() {
        return "aaaabbbb"; // 8글자
    }
}
