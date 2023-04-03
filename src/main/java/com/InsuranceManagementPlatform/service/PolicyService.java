package com.InsuranceManagementPlatform.service;

;
import com.InsuranceManagementPlatform.entity.Policy;

import java.util.List;

;

public interface PolicyService {

    public  List<Policy> findAll();

    public Policy findById(int insuranceId);
    

    public Policy save(Policy thePolicy);

    public void deleteById(int insuranceId);


    Policy addPolicy(Policy thePolicy);


}
