package com.InsuranceManagementPlatform.service;

import com.InsuranceManagementPlatform.dao.ClaimRepository;
import com.InsuranceManagementPlatform.dao.ClientRepository;

import com.InsuranceManagementPlatform.entity.Claim;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

;

@Service
public class ClaimServiceImpl implements ClaimService{

    private ClaimRepository claimRepository;

    public ClaimServiceImpl(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @Override
    public List<Claim> findAll() {
        return  claimRepository.findAll();
    }

    @Override
    public Claim findById(int claimId) {
        Optional<Claim> result = claimRepository.findById(claimId);

        if(result.isPresent()) return result.get();
        else throw new RuntimeException("Did not find the claimId");

    }

    @Override
    public Claim addClaim(Claim theClaim) {

        return claimRepository.save(theClaim);
    }

    @Override
    public Claim save(Claim theClaim) {
        return claimRepository.save(theClaim);
    }

    @Override
    public void deleteById(int claimId) {
        claimRepository.deleteById(claimId);
    }


}
