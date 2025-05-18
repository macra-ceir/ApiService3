package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.RunningAlertDb;

public interface RunningAlertDbRepository extends JpaRepository<RunningAlertDb, Long>, JpaSpecificationExecutor<RunningAlertDb> {

	public RunningAlertDb getById(long id);
	
	public RunningAlertDb getByAlertId(String alertId);
}
