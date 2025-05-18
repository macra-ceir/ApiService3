package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.PolicyConfigurationDb;

public interface PolicyConfigurationDbRepository extends JpaRepository<PolicyConfigurationDb, Long>, JpaSpecificationExecutor<PolicyConfigurationDb> {

	public 	PolicyConfigurationDb getByTag(String tag);

	public PolicyConfigurationDb getById(Long id);

}
