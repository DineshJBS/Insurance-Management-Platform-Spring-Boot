package com.InsuranceManagementPlatform.dao;

;
import com.InsuranceManagementPlatform.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

;

public interface PolicyRepository extends JpaRepository<Policy,Integer> {
}
