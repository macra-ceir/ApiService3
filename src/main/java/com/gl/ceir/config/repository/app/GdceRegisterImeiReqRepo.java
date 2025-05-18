package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.GdceRegisterImeiReq;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GdceRegisterImeiReqRepo extends JpaRepository<GdceRegisterImeiReq, Long> {

    public GdceRegisterImeiReq save(GdceRegisterImeiReq gdceRegisterImeiReq);

}
