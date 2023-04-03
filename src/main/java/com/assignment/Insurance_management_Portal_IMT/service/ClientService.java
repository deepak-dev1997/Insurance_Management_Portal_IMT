package com.assignment.Insurance_management_Portal_IMT.service;

import com.assignment.Insurance_management_Portal_IMT.entity.Client;
import com.assignment.Insurance_management_Portal_IMT.entryDTO.ClientEntry;
import com.assignment.Insurance_management_Portal_IMT.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClient(){
        List<Client> clientList=clientRepository.findAll();
        return clientList;
    }

    public Client getClientById(int id) throws Exception{

        Client client = clientRepository.findById(id).get();
        if(client==null) throw new Exception("Invalid Client Id");
        return client;

    }

    public String createClient(ClientEntry clientEntry) throws Exception{
        if(clientEntry.getName().equals("") || clientEntry.getName()==null) throw new Exception("Name not found");
        if(clientEntry.getAddress().equals("") || clientEntry.getAddress()==null) throw new Exception("Address not found");
        if(clientEntry.getContactInformation().equals("") || clientEntry.getContactInformation()==null) throw new Exception("Contact information is mandatory");

        Client client=new Client();
        client.setName(clientEntry.getName());
        client.setDob(clientEntry.getDob());
        client.setAddress(clientEntry.getAddress());
        client.setContactInformation(clientEntry.getContactInformation());
        clientRepository.save(client);
        return "Client added successfully";
    }

    public String updateClient(int id, ClientEntry clientEntry) throws Exception{
        Client client=clientRepository.findById(id).get();
        if(client==null) throw new Exception("client not found");
        if(clientEntry.getName().equals("") || clientEntry.getName()==null) throw new Exception("Name cannot be updated as it is empty");
        if(clientEntry.getAddress().equals("") || clientEntry.getAddress()==null) throw new Exception("Address cannot be updated as it is empty");
        if(clientEntry.getContactInformation().equals("") || clientEntry.getContactInformation()==null) throw new Exception("Contact cannot be updated as it is empty");
        client.setName(clientEntry.getName());
        client.setAddress(clientEntry.getAddress());
        client.setDob(clientEntry.getDob());
        client.setContactInformation(clientEntry.getContactInformation());
        clientRepository.save(client);
        return "Client information updated Successfully";
    }

    public String deleteClient(int id) throws Exception{
        try {
            Client client = clientRepository.findById(id).get();
        }
        catch (Exception e) {
            throw new Exception("Client cannot be deleted as the id is invalid");
        }
        clientRepository.deleteById(id);
        return "Client Deleted Sussessfully";
    }
}
