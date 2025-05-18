package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.ImeiPairDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ImeiPairDetailRepo extends JpaRepository<ImeiPairDetail, Long>
        , JpaSpecificationExecutor<ImeiPairDetail> {

    public ImeiPairDetail save(ImeiPairDetail e);
    public List<ImeiPairDetail> getByImei(String imei);
  //  @Transactional
    public void deleteByImei(String imei);

}