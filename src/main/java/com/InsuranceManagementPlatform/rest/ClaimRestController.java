package com.InsuranceManagementPlatform.rest;

import com.InsuranceManagementPlatform.entity.Claim;
import com.InsuranceManagementPlatform.service.ClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClaimRestController {

    private ClaimService claimService;

    public ClaimRestController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @GetMapping("/claims")
    public List<Claim> findAll() {

        return claimService.findAll();
    }


    @GetMapping("/claims/{claimId}")
    public Claim findById(@PathVariable int claimId) {

        Claim claim = claimService.findById(claimId);

        if (claim == null) throw new RuntimeException("Client id not found " + claimId);

        return claim;
    }


    @PostMapping("/claims")
    public Claim addClaim(@RequestBody Claim theClaim) {

        theClaim.setClaimId(0);

        Claim postClaim = claimService.addClaim(theClaim);

        return postClaim;
    }


    @PutMapping("/claims/{claimId}")
    public Claim updateClaim(@PathVariable int claimId, @RequestBody Claim theClaim) {


        Claim tempClaim = claimService.findById(claimId);
        if (tempClaim == null) throw new RuntimeException("Claim id not found to update" + claimId);
        else {

            tempClaim = claimService.save(theClaim);
        }
        return tempClaim;
    }


    @DeleteMapping("/claims/{claimId}")
    public String deleteClaim(@PathVariable int claimId) {
        Claim tempClaim = claimService.findById(claimId);
        if (tempClaim == null) throw new RuntimeException("Client id not found to update" + claimId);
        else {
            // updating the client
            claimService.deleteById(claimId);
        }

        return "Claim deleted : " + claimId;
    }


}
