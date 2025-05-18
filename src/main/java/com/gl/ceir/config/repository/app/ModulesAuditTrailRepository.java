package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.ModulesAuditTrails;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulesAuditTrailRepository extends JpaRepository<ModulesAuditTrails, Long>, JpaSpecificationExecutor<ModulesAuditTrails> {

    public ModulesAuditTrails getById(long id);

    //   public ModulesAuditTrail getBysaveId(ModulesAuditTrail modulesAuditTrail);


}
