package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.CheckImeiResponseParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CheckImeiResponseParamRepository extends JpaRepository<CheckImeiResponseParam, Long>, JpaSpecificationExecutor<CheckImeiResponseParam> {

    public CheckImeiResponseParam getByTagAndFeatureName(String tag, String featureName);

    public CheckImeiResponseParam getById(Long id);

    // public CheckImeiResponseParam getByTagAndTypeAndFeatureNam(String tag, int type, String featureName);

    public CheckImeiResponseParam getByTagAndLanguage(String tag, String language);

    public List<CheckImeiResponseParam> findAll();
}
