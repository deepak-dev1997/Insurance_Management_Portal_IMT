package com.assignment.Insurance_management_Portal_IMT.controller;

import com.assignment.Insurance_management_Portal_IMT.entity.Client;
import com.assignment.Insurance_management_Portal_IMT.entryDTO.ClientEntry;
import com.assignment.Insurance_management_Portal_IMT.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getallClients(){
        List<Client> clientList=clientService.getAllClient();
        if(clientList==null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(clientList,HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id")int id) throws Exception{
        try{
            return new ResponseEntity<>(clientService.getClientById(id),HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> createClient(@RequestBody ClientEntry clientEntry){
        try{
            return new ResponseEntity<>(clientService.createClient(clientEntry),HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.PARTIAL_CONTENT);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable(value = "id") int id,@RequestBody ClientEntry clientEntry){
        try{
            return new ResponseEntity<>(clientService.updateClient(id,clientEntry),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable(value = "id") int id){
        try{
            return new ResponseEntity<>(clientService.deleteClient(id),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }




}
