package com.example.userRoleApp.roleApp.controller;

import com.example.userRoleApp.roleApp.entity.PermitEntity;
import com.example.userRoleApp.roleApp.exeptions.PermitAlreadyExistException;
import com.example.userRoleApp.roleApp.exeptions.PermitNotFoundException;
import com.example.userRoleApp.roleApp.service.PermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permits")
public class PermitController {

    @Autowired
    private PermitService permitService;

    @PostMapping
    public ResponseEntity registration(@RequestBody PermitEntity permit){
        try {
            permitService.registration(permit);
            return ResponseEntity.ok("permit registered");
        }catch (PermitAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());}
        catch (Exception e){
            return ResponseEntity.badRequest().body("An error has occured");
        }
    }
    @GetMapping
    public ResponseEntity getOnePermit(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(permitService.getOne(id));
        } catch (PermitNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllPermits() {
        try {
            return ResponseEntity.ok(permitService.getAll());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateOnePermit(@RequestBody PermitEntity permit){
        try {
            permitService.updateOne(permit);
            return ResponseEntity.ok("permit updated");
        }catch (PermitNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());}
        catch (Exception e){
            return ResponseEntity.badRequest().body("An error has occured");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePermit(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(permitService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
