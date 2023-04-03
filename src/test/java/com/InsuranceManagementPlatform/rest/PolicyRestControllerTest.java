package com.InsuranceManagementPlatform.rest;


import com.InsuranceManagementPlatform.entity.Policy;
import com.InsuranceManagementPlatform.service.PolicyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class PolicyRestControllerTest {

    private PolicyService policyService;
    private PolicyRestController policyController;

    @BeforeEach
    void setUp() {
        policyService = mock(PolicyService.class);
        policyController = new PolicyRestController(policyService);
    }

    @Test
    void testFindAll() {

        List<Policy> policy = new ArrayList<>();
        policy.add(new Policy(1, 550000, "true", "11/01/2022", "12/11/2023"));
        policy.add(new Policy(2, 550000, "true", "11/01/2022", "12/11/2023"));

        when(policyService.findAll()).thenReturn(policy);


        List<Policy> result =policyController.findAll();


        assertEquals(policy, result);
    }

    @Test
    void testFindById() {

        int policyId = 123;
        Policy policy  = new Policy(1, 550000, "true", "11/01/2022", "12/11/2023");
        when(policyService.findById(policyId)).thenReturn(policy);


       Policy result = policyController.findById(policyId);


        assertEquals(policy, result);
    }

    @Test
    void testFindByIdNotFound() {

        int policyId = 123;
        when(policyService.findById(policyId)).thenReturn(null);


        assertThrows(RuntimeException.class, () -> policyController.findById(policyId));
    }

    @Test
    void testAddClaim() {

        Policy policy = new Policy(1, 550000, "true", "11/01/2022", "12/11/2023");
        when(policyService.addPolicy(policy)).thenReturn(policy);


        Policy result = policyController.addPolicy(policy);


        assertEquals(policy, result);
    }

    @Test
    void testUpdatePolicy() {

        int policyId = 123;
        Policy policy = new Policy(1, 550000, "true", "11/01/2022", "12/11/2023");
        when(policyService.findById(policyId)).thenReturn(policy);
        when(policyService.save(policy)).thenReturn(policy);


        Policy result  = policyController.updateClaim(policyId, policy);


        assertEquals(policy, result);
    }

    @Test
    void testUpdatePolicyNotFound() {

        int policyId = 123;
        Policy policy = new Policy(1, 550000, "true", "11/01/2022", "12/11/2023");
        when(policyService.findById(policyId)).thenReturn(null);


        assertThrows(RuntimeException.class, () -> policyController.updateClaim(policyId, policy));
    }

    @Test
    void testDeletePolicy() {

        int policyId = 123;
        Policy policy = new Policy(1, 550000, "true", "11/01/2022", "12/11/2023");
        when(policyService.findById(policyId)).thenReturn(policy);


        String result = policyController.deletePolicy(policyId);


        assertEquals("Policy deleted : " + policyId, result);
        verify(policyService, times(1)).deleteById(policyId);
    }

    @Test
    void testDeletePolicyNotFound() {

        int policyId = 123;
        when(policyService.findById(policyId)).thenReturn(null);


        assertThrows(RuntimeException.class, () -> policyController.deletePolicy(policyId));
    }
}
