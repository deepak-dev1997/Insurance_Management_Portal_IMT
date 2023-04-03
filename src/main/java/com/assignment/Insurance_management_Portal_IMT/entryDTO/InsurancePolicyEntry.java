package com.assignment.Insurance_management_Portal_IMT.entryDTO;

import com.assignment.Insurance_management_Portal_IMT.enums.InsuranceType;
import lombok.Data;

import java.util.Date;

@Data
public class InsurancePolicyEntry {

    private String policyNumber;

    private InsuranceType insuranceType;

    private int coverageAmount;

    private int premiumAmount;

    private Date endDate;

    private int clientId;
}
