package com.example.userRoleApp.roleApp.service;

import com.example.userRoleApp.roleApp.entity.RoleEntity;
import com.example.userRoleApp.roleApp.exeptions.RoleAlreadyExistException;
import com.example.userRoleApp.roleApp.exeptions.RoleNotFoundException;
import com.example.userRoleApp.roleApp.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;


    public RoleEntity registration(RoleEntity role) throws RoleAlreadyExistException {
        if (roleRepo.findByName(role.getName()) != null){
            throw new RoleAlreadyExistException("This role already exists");
        }
        return roleRepo.save(role);
    }


    public RoleEntity updateOne(RoleEntity role) throws RoleNotFoundException {

        if (roleRepo.findById(role.getId()).get() == null) {
            throw new RoleNotFoundException("Role not found");
        }
        return roleRepo.save(role);
    }



    public RoleEntity getOne(Long id) throws RoleNotFoundException {
        RoleEntity role = roleRepo.findById(id).get();
        if (role == null) {
            throw new RoleNotFoundException("Role not found");
        }
        return role;
    }

    public ArrayList<RoleEntity> getAll() {
        ArrayList<RoleEntity> allRoles= (ArrayList<RoleEntity>) roleRepo.findAll();

        return allRoles;
    }

    public Long delete(Long id) {
        roleRepo.deleteById(id);

        return id;
    }
}
