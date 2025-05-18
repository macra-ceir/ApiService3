package com.gl.ceir.config.repository.audit;

import com.gl.ceir.config.model.audit.ModulesAuditTrail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maverick
 */
@Repository
public interface ModulesAuditTrailRepository extends JpaRepository<ModulesAuditTrail, Long> {

    //  @Override
    public ModulesAuditTrail save(ModulesAuditTrail modulesAuditTrail);
}
