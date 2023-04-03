package com.InsuranceManagementPlatform.entity;
import jakarta.persistence.*;


@Entity
@Table(name="claim")
public class Claim {


    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="claim_id")
    private  int claimId;

    public Claim(){}
    @Column(name = "description")
    private String description;

    @Column(name = "claim_date")
    private String claimDate;

    @Column(name = "claim_status")
    private String claimStatus;

    public Claim(int claimId, String description, String claimDate, String claimStatus) {
        this.claimId = claimId;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
    }

    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }


}
