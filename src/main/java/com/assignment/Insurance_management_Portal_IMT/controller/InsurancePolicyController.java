package com.assignment.Insurance_management_Portal_IMT.controller;


import com.assignment.Insurance_management_Portal_IMT.entity.InsurancePolicy;
import com.assignment.Insurance_management_Portal_IMT.entryDTO.InsurancePolicyEntry;
import com.assignment.Insurance_management_Portal_IMT.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    @Autowired
    InsuranceService insuranceService;

    @PostMapping
    public ResponseEntity<String> createInsurance(@RequestBody InsurancePolicyEntry insurancePolicyEntry) {
        try {
            return new ResponseEntity<>(insuranceService.createInsurance(insurancePolicyEntry), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<InsurancePolicy>> getAll(){
        List<InsurancePolicy> insurancePolicyList=insuranceService.getAll();
        return new ResponseEntity<>(insurancePolicyList,HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> getById(@PathVariable(value = "id") int id ){
        try{
            return new ResponseEntity<>(insuranceService.getById(id),HttpStatus.FOUND);
        }
        catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePolicy(@PathVariable(value = "id")int id,@RequestBody InsurancePolicyEntry insurancePolicyEntry){
        try{

            return new ResponseEntity<>(insuranceService.updateInsurance(id,insurancePolicyEntry),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePolicy(@PathVariable(value = "id")int id){
        try{
            return new ResponseEntity<>(insuranceService.deletePolicy(id),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
