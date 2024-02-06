package com.b2bsaasapp.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.b2bsaasapp.domain.Tenant;
import com.b2bsaasapp.domain.TenantRequest;
import com.descope.client.DescopeClient;
import com.descope.exception.DescopeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sravanrao
 *
 */

@Service
public class TenantServiceImpl implements TenantService {

    private  DescopeClient descopeClient;
    private  DynamoDBMapper dynamoDBMapper;

    @Autowired
    public TenantServiceImpl(DescopeClient descopeClient, DynamoDBMapper dynamoDBMapper) {
        this.descopeClient = descopeClient;
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public String createTenant(TenantRequest tenantRequest) {
        try {
            String tenantId = descopeClient.getManagementServices().getTenantService()
                    .create(tenantRequest.getName(), tenantRequest.getSelfProvisioningDomains(), tenantRequest.getCustomAttributes());

            Tenant tenant = new Tenant();
            tenant.setName(tenantRequest.getName());
            tenant.setTenantId(tenantId);
            // Save tenant information in DynamoDB
            dynamoDBMapper.save(tenant);
            return tenantId;

        } catch (DescopeException de) {

            throw new RuntimeException("Failed to create tenant: " + de.getMessage(), de);
        }
    }


}