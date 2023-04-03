package com.InsuranceManagementPlatform.rest;

import com.InsuranceManagementPlatform.entity.Claim;
import com.InsuranceManagementPlatform.service.ClaimService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ClaimRestControllerTest {

    private ClaimService claimService;
    private ClaimRestController claimController;

    @BeforeEach
    void setUp() {
        claimService = mock(ClaimService.class);
        claimController = new ClaimRestController(claimService);
    }

    @Test
    void testFindAll() {

        List<Claim> claims = new ArrayList<>();
        claims.add(new Claim(1, "This is first claim", "11/01/2023", "active" ));
        claims.add(new Claim(2, "This is first claim", "11/01/2023", "active"));
        when(claimService.findAll()).thenReturn(claims);


        List<Claim> result =claimController.findAll();


        assertEquals(claims, result);
    }

    @Test
    void testFindById() {

        int claimId = 123;
        Claim claims = new Claim(claimId, "This is first claim", "11/01/2023", "active"  );
        when(claimService.findById(claimId)).thenReturn(claims);


        Claim result = claimController.findById(claimId);


        assertEquals(claims, result);
    }

    @Test
    void testFindByIdNotFound() {

        int claimId = 123;
        when(claimService.findById(claimId)).thenReturn(null);


        assertThrows(RuntimeException.class, () -> claimController.findById(claimId));
    }

    @Test
    void testAddClaim() {

        Claim claim = new Claim(1, "This is first claim", "11/01/2023", "active"  );
        when(claimService.addClaim(claim)).thenReturn(claim);


        Claim result = claimController.addClaim(claim);


        assertEquals(claim, result);
    }

    @Test
    void testUpdateClaim() {

        int claimId = 123;
        Claim claim = new Claim(1, "This is first claim", "11/01/2023", "active"  );
        when(claimService.findById(claimId)).thenReturn(claim);
        when(claimService.save(claim)).thenReturn(claim);


        Claim result  = claimController.updateClaim(claimId, claim);


        assertEquals(claim, result);
    }

    @Test
    void testUpdateClaimNotFound() {

        int claimId = 123;
        Claim claim =  new Claim(1, "This is first claim", "11/01/2023", "active"  );
        when(claimService.findById(claimId)).thenReturn(null);


        assertThrows(RuntimeException.class, () -> claimController.updateClaim(claimId, claim));
    }

    @Test
    void testDeleteClaim() {

        int claimId = 123;
        Claim claim =  new Claim(1, "This is first claim", "11/01/2023", "active"  );
        when(claimService.findById(claimId)).thenReturn(claim);


        String result = claimController.deleteClaim(claimId);


        assertEquals("Claim deleted : " + claimId, result);
        verify(claimService, times(1)).deleteById(claimId);
    }

    @Test
    void testDeleteClaimNotFound() {

        int claimId = 123;
        when(claimService.findById(claimId)).thenReturn(null);


        assertThrows(RuntimeException.class, () -> claimController.deleteClaim(claimId));
    }
}
