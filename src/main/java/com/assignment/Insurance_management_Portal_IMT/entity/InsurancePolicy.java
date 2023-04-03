package com.assignment.Insurance_management_Portal_IMT.entity;

import com.assignment.Insurance_management_Portal_IMT.enums.InsuranceType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "insurance_policy")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties("client")
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String policy_number;

    @Enumerated(value = EnumType.STRING)
    private InsuranceType insuranceType;


    private int coverageAmount;

    private int premiumAmount;

    @CreationTimestamp
    private Date startDate;

    private Date endDate;

    @ManyToOne
    @JoinColumn
    private Client client;

    @OneToMany(mappedBy = "insurancePolicy",cascade = CascadeType.ALL)
    private List<Claim> claimList=new ArrayList<>();

}
