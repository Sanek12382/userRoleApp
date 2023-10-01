package com.example.userRoleApp.roleApp.repository;

import com.example.userRoleApp.roleApp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByName(String name);
}

