package com.example.userRoleApp.roleApp.controller;

import com.example.userRoleApp.roleApp.entity.RoleEntity;
import com.example.userRoleApp.roleApp.exeptions.RoleAlreadyExistException;
import com.example.userRoleApp.roleApp.exeptions.RoleNotFoundException;
import com.example.userRoleApp.roleApp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity registration(@RequestBody RoleEntity role){
        try {
            roleService.registration(role);
            return ResponseEntity.ok("role registered");
        }catch (RoleAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());}
        catch (Exception e){
            return ResponseEntity.badRequest().body("An error has occured");
        }
    }
    @GetMapping
    public ResponseEntity getOneRole(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(roleService.getOne(id));
        } catch (RoleNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllRoles() {
        try {
            return ResponseEntity.ok(roleService.getAll());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateOneRole(@RequestBody RoleEntity role){
        try {
            roleService.updateOne(role);
            return ResponseEntity.ok("role updated");
        }catch (RoleNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());}
        catch (Exception e){
            return ResponseEntity.badRequest().body("An error has occured");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRole(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(roleService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
