package com.gl.ceir.config.repository.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ceir.config.model.app.SystemConfigListDb;

public interface SystemConfigListRepository extends JpaRepository<SystemConfigListDb, Long> {
	
	public List<SystemConfigListDb> findByTag(String tag);
        
        public SystemConfigListDb findByTagAndInterp(String tag,String interp);
}
