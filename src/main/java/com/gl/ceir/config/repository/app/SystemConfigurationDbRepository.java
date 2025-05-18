package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.SystemConfigurationDb;

public interface SystemConfigurationDbRepository extends JpaRepository<SystemConfigurationDb, Long>, JpaSpecificationExecutor<SystemConfigurationDb> {


	public SystemConfigurationDb getByTag(String tag);

	public SystemConfigurationDb getById(Long id);

//	public SystemConfigurationDb getByTagAndTypeAndFeatureName(String tag , int type, String featureName);


}
