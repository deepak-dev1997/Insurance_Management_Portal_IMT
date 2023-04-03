package com.assignment.Insurance_management_Portal_IMT.service;

import com.assignment.Insurance_management_Portal_IMT.entity.Client;
import com.assignment.Insurance_management_Portal_IMT.entity.InsurancePolicy;
import com.assignment.Insurance_management_Portal_IMT.entryDTO.InsurancePolicyEntry;
import com.assignment.Insurance_management_Portal_IMT.repository.ClientRepository;
import com.assignment.Insurance_management_Portal_IMT.repository.InsuranceRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    @Autowired
    InsuranceRespository insuranceRespository;

    @Autowired
    ClientRepository clientRepository;

    public String createInsurance(InsurancePolicyEntry insurancePolicyEntry) throws Exception{
        //validation;
        Client client=new Client();
        try {
            client = clientRepository.findById(insurancePolicyEntry.getClientId()).get();
        }
        catch (Exception e) {
            throw new Exception("Client Id is invalid");
        }

//        if(insurancePolicyEntry.getInsuranceType().equals("HEALTH") ||
//                insurancePolicyEntry.getInsuranceType().equals("MOTOR") ||
//                insurancePolicyEntry.getInsuranceType().equals("HOME") ||
//                insurancePolicyEntry.getInsuranceType().equals("TRAVEL") ||
//                insurancePolicyEntry.getInsuranceType().equals("FIRE")){ }
//        else{
//            throw new Exception("Please enter a valid insurance type");
//        }

        InsurancePolicy insurancePolicy=new InsurancePolicy();
        insurancePolicy.setInsuranceType(insurancePolicyEntry.getInsuranceType());
        insurancePolicy.setPolicy_number(insurancePolicyEntry.getPolicyNumber());
        insurancePolicy.setClient(client);
        insurancePolicy.setCoverageAmount(insurancePolicyEntry.getCoverageAmount());
        insurancePolicy.setEndDate(insurancePolicyEntry.getEndDate());
        insurancePolicy.setPremiumAmount(insurancePolicyEntry.getPremiumAmount());

        client.getInsurancePolicies().add(insurancePolicy);
        try {
            clientRepository.save(client);
        }
        catch (Exception e){
            throw new Exception("Policy number already exists");
        }

        return "Insurance police created successfully";





    }

    public List<InsurancePolicy> getAll() {

        List<InsurancePolicy> insurancePolicyList=insuranceRespository.findAll();
        return insurancePolicyList;

    }

    public InsurancePolicy getById(int id) throws Exception{
        try{
            InsurancePolicy insurancePolicy=insuranceRespository.findById(id).get();
            return insurancePolicy;
        }
        catch (Exception e){
            throw new Exception("Invalid Policy number");
        }
    }

    public String updateInsurance(int id,InsurancePolicyEntry insurancePolicyEntry) throws Exception{
        InsurancePolicy insurancePolicy=new InsurancePolicy();
        try{
            insurancePolicy=insuranceRespository.findById(id).get();
        }
        catch (Exception e){
            throw new Exception("Invalid insurance id");
        }
        if(insurancePolicyEntry.getPolicyNumber()==null || insurancePolicyEntry.getPolicyNumber().equals("")) throw new Exception("Insurance policy Number is mandatory");

        insurancePolicy.setPremiumAmount(insurancePolicyEntry.getPremiumAmount());
        insurancePolicy.setInsuranceType(insurancePolicyEntry.getInsuranceType());
        insurancePolicy.setPolicy_number(insurancePolicyEntry.getPolicyNumber());
        insurancePolicy.setEndDate(insurancePolicyEntry.getEndDate());
        insurancePolicy.setCoverageAmount(insurancePolicyEntry.getCoverageAmount());

        try{
            insuranceRespository.save(insurancePolicy);
            return "Policy Updated successfully";
        }
        catch (Exception e){
            throw new Exception("Insurance policy number is duplicate. Please enter a valid Policy number");
        }

    }

    public String deletePolicy(int id) throws Exception{
        try{
            insuranceRespository.deleteById(id);
            return "Policy Deleted Successfully";
        }
        catch (Exception e){
            throw new Exception("Cannot delete this policy as there is no insurance available with given id");
        }
    }

}
