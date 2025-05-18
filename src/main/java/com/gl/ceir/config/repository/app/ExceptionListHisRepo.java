package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.ExceptionListHist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExceptionListHisRepo extends JpaRepository<ExceptionListHist, Long>
        , JpaSpecificationExecutor<ExceptionListHist> {
    public ExceptionListHist save(ExceptionListHist e);
}