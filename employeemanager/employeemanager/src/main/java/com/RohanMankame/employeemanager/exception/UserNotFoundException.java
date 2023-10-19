package com.RohanMankame.employeemanager.exception;

public class UserNotFoundException extends  RuntimeException {
    public UserNotFoundException(String userWasNotFound) {
        super(userWasNotFound);
    }
}
