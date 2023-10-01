package com.example.userRoleApp.roleApp.service;

import com.example.userRoleApp.roleApp.entity.PermitEntity;
import com.example.userRoleApp.roleApp.exeptions.PermitAlreadyExistException;
import com.example.userRoleApp.roleApp.exeptions.PermitNotFoundException;
import com.example.userRoleApp.roleApp.repository.PermitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PermitService {

    @Autowired
    private PermitRepo permitRepo;


    public PermitEntity registration(PermitEntity permit) throws PermitAlreadyExistException {
        if (permitRepo.findByName(permit.getName()) != null){
            throw new PermitAlreadyExistException("This permit already exists");
        }
        return permitRepo.save(permit);
    }


    public PermitEntity updateOne(PermitEntity permit) throws PermitNotFoundException {

        if (permitRepo.findById(permit.getId()).get() == null) {
            throw new PermitNotFoundException("Permit not found");
        }
        return permitRepo.save(permit);
    }



    public PermitEntity getOne(Long id) throws PermitNotFoundException {
        PermitEntity permit = permitRepo.findById(id).get();
        if (permit == null) {
            throw new PermitNotFoundException("Permit not found");
        }
        return permit;
    }

    public ArrayList<PermitEntity> getAll() {
        ArrayList<PermitEntity> allPermits= (ArrayList<PermitEntity>) permitRepo.findAll();

        return allPermits;
    }

    public Long delete(Long id) {
        permitRepo.deleteById(id);

        return id;
    }
}
