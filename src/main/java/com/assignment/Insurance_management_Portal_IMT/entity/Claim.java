package com.assignment.Insurance_management_Portal_IMT.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "claim")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties("insurancePolicy")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String claimNumber;

    private String description;

    @CreationTimestamp
    private Date claimDate;

    private String claimStatus;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private InsurancePolicy insurancePolicy;

}

