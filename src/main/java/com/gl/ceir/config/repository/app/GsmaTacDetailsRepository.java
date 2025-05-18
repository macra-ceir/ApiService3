package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.GsmaTacDetails;


public interface GsmaTacDetailsRepository extends JpaRepository<GsmaTacDetails, Long>, JpaSpecificationExecutor<GsmaTacDetails> {

    public GsmaTacDetails getBydeviceId(String tac);

}
