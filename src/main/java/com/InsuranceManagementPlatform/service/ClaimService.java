package com.InsuranceManagementPlatform.service;

import com.InsuranceManagementPlatform.entity.Claim;
;

import java.util.List;

public interface ClaimService {

    public  List<Claim> findAll();

    public Claim findById(int clientId);

    public Claim addClaim(Claim theClaim);

    public Claim save(Claim theClaim);

    public void deleteById(int claimId);






}
