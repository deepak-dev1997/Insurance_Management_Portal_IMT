package com.assignment.Insurance_management_Portal_IMT.entryDTO;

import lombok.Data;

@Data
public class ClaimEntry {
    private String claimNumber;

    private String description;

    private String claimStatus;

    private int policyId;
}
