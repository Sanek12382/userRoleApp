package com.example.userRoleApp.roleApp.controller;


import com.example.userRoleApp.roleApp.entity.UserEntity;
import com.example.userRoleApp.roleApp.exeptions.UserAlreadyExistException;
import com.example.userRoleApp.roleApp.repository.UserRepo;
import com.example.userRoleApp.roleApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("user registered");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());}
        catch (Exception e){
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
