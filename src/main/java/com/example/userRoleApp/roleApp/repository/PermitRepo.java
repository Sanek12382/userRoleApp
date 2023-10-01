package com.example.userRoleApp.roleApp.repository;

import com.example.userRoleApp.roleApp.entity.PermitEntity;
import org.springframework.data.repository.CrudRepository;

public interface PermitRepo extends CrudRepository<PermitEntity, Long> {
    PermitEntity findByName(String name);
}
