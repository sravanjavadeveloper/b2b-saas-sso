package com.b2bsaasapp.config;

import com.descope.client.Config;
import com.descope.client.DescopeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author sravanrao
 *
 */

@Configuration
public class DescopeConfig {

    @Value("${descope.projectId}")
    private String projectId;

    @Value("${descope.managementKey}")
    private String managementKey;

    @Bean
    public DescopeClient descopeClient() {
        // Initialize DescopeClient with your project configuration
        return new DescopeClient(Config.builder()
                .projectId(projectId)
                .managementKey(managementKey)
                .build());
    }
}
