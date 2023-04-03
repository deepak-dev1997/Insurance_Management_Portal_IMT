package com.assignment.Insurance_management_Portal_IMT.service;

import com.assignment.Insurance_management_Portal_IMT.entity.Claim;
import com.assignment.Insurance_management_Portal_IMT.entity.InsurancePolicy;
import com.assignment.Insurance_management_Portal_IMT.entryDTO.ClaimEntry;
import com.assignment.Insurance_management_Portal_IMT.repository.ClaimRepository;
import com.assignment.Insurance_management_Portal_IMT.repository.ClientRepository;
import com.assignment.Insurance_management_Portal_IMT.repository.InsuranceRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {
    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    InsuranceRespository insuranceRespository;

    @Autowired
    ClientRepository clientRepository;

    public String createClaim(ClaimEntry claimEntry) throws Exception{
        InsurancePolicy insurancePolicy=new InsurancePolicy();
        try{
            insurancePolicy=insuranceRespository.findById(claimEntry.getPolicyId()).get();
        }
        catch (Exception e){
            throw new Exception("Policy ID missing or Invalid");
        }

        Claim claim=new Claim();
        claim.setClaimNumber(claimEntry.getClaimNumber());
        claim.setDescription(claimEntry.getDescription());
        claim.setInsurancePolicy(insurancePolicy);
        if(claimEntry.getClaimStatus().equals("") || claimEntry.getClaimStatus()==null){
            claim.setClaimStatus("Status not updated yet");
        }
        else{
            claim.setClaimStatus(claimEntry.getClaimStatus());
        }
        insurancePolicy.getClaimList().add(claim);
        insuranceRespository.save(insurancePolicy);
        return "Claim added Successfully";


    }

    public List<Claim> getAll() throws Exception{
        try {
            List<Claim> claimList = claimRepository.findAll();
            return claimList;
        }
        catch (Exception e){
            throw new Exception("List is empty");
        }
    }

    public Claim getById(int id) throws Exception{
        try{
            Claim claim=claimRepository.findById(id).get();
            return claim;
        }
        catch (Exception e){
            throw new Exception("Claim is incorrect");
        }

    }

    public String updateClaim(int id,ClaimEntry claimEntry) throws Exception{
        Claim claim=new Claim();
        try{
            claim=claimRepository.findById(id).get();
        }
        catch (Exception e){
            throw new Exception("Invalid claim ID");
        }
        InsurancePolicy insurancePolicy=insuranceRespository.findById(claimEntry.getPolicyId()).get();
        claim.setClaimStatus(claimEntry.getClaimStatus());
        claim.setDescription(claimEntry.getDescription());
        claim.setInsurancePolicy(insurancePolicy);
        insuranceRespository.save(insurancePolicy);
        return "Claim updated Successfully";
    }

    public String deleteClaim(int id) throws Exception{
        try{
            claimRepository.deleteById(id);
            return "Claim Deleted Successfully";
        }
        catch (Exception e){
            throw new Exception("Cannot delete as claim with given id does not Exists");
        }
    }
}
