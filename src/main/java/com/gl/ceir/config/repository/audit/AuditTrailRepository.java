package com.gl.ceir.config.repository.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.audit.AuditTrail;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditTrailRepository extends JpaRepository<AuditTrail, Long>, JpaSpecificationExecutor<AuditTrail> {

	public AuditTrail getById(long id);
}
