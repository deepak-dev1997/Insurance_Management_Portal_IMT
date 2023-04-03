package com.assignment.Insurance_management_Portal_IMT.repository;

import com.assignment.Insurance_management_Portal_IMT.entity.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRespository extends JpaRepository<InsurancePolicy,Integer> {

}
