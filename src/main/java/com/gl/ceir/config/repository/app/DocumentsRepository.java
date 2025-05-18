package com.gl.ceir.config.repository.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.ceir.config.model.app.DocumentStatus;
import com.gl.ceir.config.model.app.Documents;

public interface DocumentsRepository extends JpaRepository<Documents, Long> {

	public List<Documents> findByImeiOrMsisdn(Long imei, Long msisdn);

}
