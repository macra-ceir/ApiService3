package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.ImeiPairDetailHis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImeiPairDetailHisRepo extends JpaRepository<ImeiPairDetailHis, Long>
        , JpaSpecificationExecutor<ImeiPairDetailHis> {
    public ImeiPairDetailHis save(ImeiPairDetailHis e);

    public ImeiPairDetailHis getByImei(Long imei);
}