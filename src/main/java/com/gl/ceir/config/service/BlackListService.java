package com.gl.ceir.config.service;

import com.gl.ceir.config.model.app.BlackList;

public interface BlackListService extends RestServices<BlackList> {
	public BlackList getByMsisdn(Long msisdn);
	public BlackList getByImei(Long imei);
}
