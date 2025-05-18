package com.gl.ceir.config.service;

import java.util.List;

import com.gl.ceir.config.model.app.DocumentStatus;
import com.gl.ceir.config.model.app.Documents;

public interface DocumentsService {
	public Documents get(Long id);

	public Documents save(Documents documents);

	public Documents updateStatus(DocumentStatus documentStatus, Long id);

	public List<Documents> getByMsisdnAndImei(Long imei, Long msisdn);
}
