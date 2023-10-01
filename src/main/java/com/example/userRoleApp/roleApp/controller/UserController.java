package com.example.userRoleApp.roleApp.controller;


import com.example.userRoleApp.roleApp.entity.UserEntity;
import com.example.userRoleApp.roleApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private  UserRepo userRepo;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            if (userRepo.findByName(user.getName()) != null){
                return ResponseEntity.badRequest().body("This user already exists");
            }
            userRepo.save(user);
            return ResponseEntity.ok("user registered");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("An error has occured");
        }
    }
    @GetMapping()
    public ResponseEntity getUsers()    {
        try {
            return  ResponseEntity.ok("server is up");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error getting all users");
        }
    }
}
