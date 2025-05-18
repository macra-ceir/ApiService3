package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.SystemConfigurationHistoryDb;

public interface SystemConfigurationHistoryDbRepository extends JpaRepository<SystemConfigurationHistoryDb, Long>,JpaSpecificationExecutor<SystemConfigurationHistoryDb> {

}
