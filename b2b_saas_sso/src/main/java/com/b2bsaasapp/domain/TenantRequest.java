package com.b2bsaasapp.domain;

import java.util.List;
import java.util.Map;

/**
 *
 * @author sravanrao
 *
 */
public class TenantRequest {
    private String name;
    private List<String> selfProvisioningDomains;
    private Map<String, Object> customAttributes;
    private String authType;

    // Constructors
    public TenantRequest() {}

    public TenantRequest(String name, List<String> selfProvisioningDomains, Map<String, Object> customAttributes, String authType) {
        this.name = name;
        this.selfProvisioningDomains = selfProvisioningDomains;
        this.customAttributes = customAttributes;
        this.authType = authType;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSelfProvisioningDomains() {
        return selfProvisioningDomains;
    }

    public void setSelfProvisioningDomains(List<String> selfProvisioningDomains) {
        this.selfProvisioningDomains = selfProvisioningDomains;
    }

    public Map<String, Object> getCustomAttributes() {
        return customAttributes;
    }

    public void setCustomAttributes(Map<String, Object> customAttributes) {
        this.customAttributes = customAttributes;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }
}

