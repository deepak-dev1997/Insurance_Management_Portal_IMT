package com.assignment.Insurance_management_Portal_IMT.repository;

import com.assignment.Insurance_management_Portal_IMT.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim,Integer> {
}