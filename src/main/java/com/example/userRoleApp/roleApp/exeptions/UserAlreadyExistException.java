package com.example.userRoleApp.roleApp.exeptions;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
