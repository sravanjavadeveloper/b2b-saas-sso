package com.b2bsaasapp.controller;

import com.b2bsaasapp.domain.TenantRequest;
import com.b2bsaasapp.service.TenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sravanrao
 *
 */

@RestController
@RequestMapping("/saas")
public class TenantController {
    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTenant(@RequestBody TenantRequest request) {
        try {
            String result = tenantService.createTenant(request);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            // Handle any runtime exceptions, including those from the service layer
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
