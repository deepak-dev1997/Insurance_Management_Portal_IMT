package com.assignment.Insurance_management_Portal_IMT.entryDTO;

import lombok.Data;

import java.util.Date;

@Data
public class ClientEntry {
    private String name;

    private Date dob;

    private String address;

    private String contactInformation;
}
