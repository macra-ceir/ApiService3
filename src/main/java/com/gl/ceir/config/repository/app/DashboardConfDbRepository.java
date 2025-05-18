package com.gl.ceir.config.repository.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ceir.config.model.app.DashboardConfDb;

public interface DashboardConfDbRepository extends JpaRepository< DashboardConfDb, Long> {
	public List<DashboardConfDb> findByUserTypeId( Integer userTypeId );
}
