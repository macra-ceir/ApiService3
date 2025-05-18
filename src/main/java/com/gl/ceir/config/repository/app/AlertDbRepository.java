package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.AlertDb;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertDbRepository extends JpaRepository<AlertDb, Long>, JpaSpecificationExecutor<AlertDb> {

	public AlertDb getById(long id);
	
	public AlertDb getByAlertId(String alertId);
}
