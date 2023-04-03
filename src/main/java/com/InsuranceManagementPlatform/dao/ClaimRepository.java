package com.InsuranceManagementPlatform.dao;

import com.InsuranceManagementPlatform.entity.Claim;
;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim,Integer> {
}
