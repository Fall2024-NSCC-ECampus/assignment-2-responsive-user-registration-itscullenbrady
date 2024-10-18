package com.example.main.service;

public interface UserValidation {
   ValidationResult validateUser(String username, String email, String password);
}
