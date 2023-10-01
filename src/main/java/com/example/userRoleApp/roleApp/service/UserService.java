package com.example.userRoleApp.roleApp.service;

import com.example.userRoleApp.roleApp.entity.UserEntity;
import com.example.userRoleApp.roleApp.exeptions.UserAlreadyExistException;
import com.example.userRoleApp.roleApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public UserEntity registration( UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByName(user.getName()) != null){
                throw new UserAlreadyExistException("This user already exists");
            }
        return userRepo.save(user);
    }
}
