package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.AttachedFileInfo;

public interface AttachedFileInfoRepository extends JpaRepository< AttachedFileInfo, Long>, JpaSpecificationExecutor<AttachedFileInfo> {
	
}
