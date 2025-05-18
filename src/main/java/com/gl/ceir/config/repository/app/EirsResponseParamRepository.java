package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.EirsResponseParam;
import com.gl.ceir.config.model.app.SystemConfigurationDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EirsResponseParamRepository extends JpaRepository<EirsResponseParam, Long>, JpaSpecificationExecutor<EirsResponseParam> {

	public EirsResponseParam getByTag(String tag);

	public EirsResponseParam getById(Long id);

//	public SystemConfigurationDb getByTagAndTypeAndFeatureName(String tag , int type, String featureName);


}
