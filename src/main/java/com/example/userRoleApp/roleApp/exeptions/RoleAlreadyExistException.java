package com.example.userRoleApp.roleApp.exeptions;

public class RoleAlreadyExistException extends Exception {

    public RoleAlreadyExistException(String message) {
        super(message);
    }
}
