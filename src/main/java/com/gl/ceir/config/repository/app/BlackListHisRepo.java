package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.BlackListHis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlackListHisRepo extends JpaRepository<BlackListHis, Long>
        , JpaSpecificationExecutor<BlackListHis> {
        public BlackListHis save (BlackListHis blackListHis);
    }