package com.assignment.Insurance_management_Portal_IMT.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="client")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private Date dob;

    private String address;


    private String contactInformation;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<InsurancePolicy> insurancePolicies=new ArrayList<>();


}

