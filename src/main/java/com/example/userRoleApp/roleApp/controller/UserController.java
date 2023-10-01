package com.example.userRoleApp.roleApp.controller;


import com.example.userRoleApp.roleApp.entity.UserEntity;
import com.example.userRoleApp.roleApp.exeptions.UserAlreadyExistException;
import com.example.userRoleApp.roleApp.exeptions.UserNotFoundException;
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
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
