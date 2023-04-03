package com.InsuranceManagementPlatform.rest;


import com.InsuranceManagementPlatform.entity.Policy;
import com.InsuranceManagementPlatform.service.PolicyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PolicyRestController {

    private PolicyService policyService;

    public PolicyRestController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping("/policies")
    public List<Policy> findAll() {

        return policyService.findAll();
    }


    @GetMapping("/policies/{policyId}")
    public Policy findById(@PathVariable int policyId) {

        Policy policy = policyService.findById(policyId);

        if (policy == null) throw new RuntimeException("Insurance Policy id not found " + policyId);

        return policy;
    }


    @PostMapping("/policies")
    public Policy addPolicy(@RequestBody Policy thePolicy) {

        thePolicy.setPolicyId(0);

        Policy postPolicy = policyService.addPolicy(thePolicy);

        return postPolicy;
    }


    @PutMapping("/policies/{policyId}")
    public Policy updateClaim(@PathVariable int policyId, @RequestBody Policy thePolicy) {


        Policy policy = policyService.findById(policyId);

        if (policy == null) throw new RuntimeException("Insurance Policy id not found " + policyId);

        else {

            policy = policyService.save(thePolicy);
        }
        return policy;
    }


    @DeleteMapping("/policies/{policyId}")
    public String deletePolicy(@PathVariable int policyId) {
        Policy tempPolicy = policyService.findById(policyId);
        if (tempPolicy == null) throw new RuntimeException("Insurance id not found to update" + policyId);
        else {

            policyService.deleteById(policyId);
        }

        return "Policy deleted : " + policyId;
    }


}
