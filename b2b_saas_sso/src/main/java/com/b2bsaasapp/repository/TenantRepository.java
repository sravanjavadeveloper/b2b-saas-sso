package com.b2bsaasapp.repository;


import com.b2bsaasapp.domain.Tenant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author sravanrao
 *
 */

@Repository
public interface TenantRepository extends CrudRepository<Tenant, String> {

}

