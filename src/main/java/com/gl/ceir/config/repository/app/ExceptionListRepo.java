package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.ExceptionList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ExceptionListRepo extends JpaRepository<ExceptionList, Long>
        , JpaSpecificationExecutor<ExceptionList> {
    public ExceptionList save(ExceptionList e);
    public void deleteByImei(String imei);

    public List<ExceptionList> getByImei(String imei);
}