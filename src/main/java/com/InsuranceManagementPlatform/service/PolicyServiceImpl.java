package com.InsuranceManagementPlatform.service;


import com.InsuranceManagementPlatform.dao.PolicyRepository;
import com.InsuranceManagementPlatform.entity.Policy;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

;

@Service
public class PolicyServiceImpl implements PolicyService {

    private PolicyRepository policyRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }


    @Override
    public List<Policy> findAll() {
        return  policyRepository.findAll();
    }


    @Override
    public Policy findById(int insuranceId) {
        Optional<Policy> result = policyRepository.findById(insuranceId);

        if(result.isPresent()) return result.get();
        else throw new RuntimeException("Did not find the insuranceId");

    }



    @Override
    public Policy addPolicy(Policy thePolicy) {

        return policyRepository.save(thePolicy);
    }

    @Override
    public Policy save(Policy thePolicy) {
        return policyRepository.save(thePolicy);
    }

    @Override
    public void deleteById(int insuranceId) {
        policyRepository.deleteById(insuranceId);
    }


}
