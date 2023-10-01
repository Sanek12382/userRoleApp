package com.example.userRoleApp.roleApp.model;

import com.example.userRoleApp.roleApp.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    long id;
    String name;
    String email;
    int age;


    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setEmail(entity.getEmail());
        model.getAge(entity.getAge());
        return model;
    }


    public User() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
