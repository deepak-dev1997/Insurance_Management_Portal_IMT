package com.assignment.Insurance_management_Portal_IMT.controller;

import com.assignment.Insurance_management_Portal_IMT.entity.Claim;
import com.assignment.Insurance_management_Portal_IMT.entryDTO.ClaimEntry;
import com.assignment.Insurance_management_Portal_IMT.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    @Autowired
    ClaimService claimService;

    @GetMapping
    public ResponseEntity<List<Claim>> getAll(){
        try{
            return new ResponseEntity<>(claimService.getAll(), HttpStatus.FOUND);
        }
        catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable(value = "id") int id ){
        try {
            return new ResponseEntity<>(claimService.getById(id),HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> createClaim(@RequestBody ClaimEntry claimEntry){
        try{
            return new ResponseEntity<>(claimService.createClaim(claimEntry),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClaim(@PathVariable(value = "id")int id,@RequestBody ClaimEntry claimEntry){
        try {
            return new ResponseEntity<>(claimService.updateClaim(id,claimEntry),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") int id ){
        try{
            return new ResponseEntity<>(claimService.deleteClaim(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
