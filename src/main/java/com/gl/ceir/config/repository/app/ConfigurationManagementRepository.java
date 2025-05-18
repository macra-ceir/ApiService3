package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ceir.config.model.app.ConfigurationManagement;

public interface ConfigurationManagementRepository extends JpaRepository<ConfigurationManagement, Long> {


	public ConfigurationManagement getByName(String name);




}
