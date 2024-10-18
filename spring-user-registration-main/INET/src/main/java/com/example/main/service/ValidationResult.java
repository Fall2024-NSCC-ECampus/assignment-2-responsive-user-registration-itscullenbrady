package com.example.main.service;

import com.example.main.model.User;

public class ValidationResult {
    public final User user;
    public boolean isEmailValid;
    public boolean isPasswordValid;
    public boolean isUsernameValid;
    public boolean isUserExists;
    public boolean isEmailExists;
    public String invalidEmailMessage = "";
    public static final String invalidPasswordMessage = "Invalid Password: Must contain at least 8 characters, one upper case letter, one lower case letter, one digit and one special character";
    public String invalidUsernameMessage = "";
    public String successMessage = "";

    public ValidationResult(User user) {
        this.user = user;
        this.isUsernameValid = true;
        this.isEmailValid = true;
        this.isPasswordValid = true;
        this.isUserExists = false;
    }

    public boolean isInputValid() {
        return isUsernameValid &&
                isEmailValid &&
                isPasswordValid &&
                !isUserExists &&
                !isEmailExists;
    }

}
