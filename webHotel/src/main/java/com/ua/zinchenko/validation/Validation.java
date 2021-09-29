package com.ua.zinchenko.validation;

import java.util.regex.Pattern;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class Validation {
    public boolean validationForPassword(String password) {
        return Pattern.matches("((?=.*[a-z]).{1,20})", password);
    }

    public boolean validationForName(String name) {
        return Pattern.matches("((?=.*[A-Z])(?=.*[a-z]).{1,20})", name);
    }

    public boolean validationForClassInApplication(String classOfRoom) {
        return Pattern.matches("(?=.*[A-Z])(?=.*[a-z]).{1,25}", classOfRoom);
    }

    public boolean validationForStatusInApplication(String statusOfRoom) {
        return Pattern.matches("(?=.*[A-Z])(?=.*[a-z]).{1,25}", statusOfRoom);
    }
}
