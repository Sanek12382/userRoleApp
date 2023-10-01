package com.example.userRoleApp.roleApp.repository;

import com.example.userRoleApp.roleApp.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
}
