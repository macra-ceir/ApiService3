package com.gl.ceir.config.service;

import java.util.List;

import com.gl.ceir.config.model.app.DuplicateImeiMsisdn;
import com.gl.ceir.config.model.app.ImeiMsisdnIdentity;
import com.gl.ceir.config.model.app.PendingActions;

public interface DuplicateImeiMsisdnService extends RestServices<DuplicateImeiMsisdn> {
	public DuplicateImeiMsisdn get(ImeiMsisdnIdentity imeiMsisdnIdentity);

	public void delete(ImeiMsisdnIdentity imeiMsisdnIdentity);

	public DuplicateImeiMsisdn update(DuplicateImeiMsisdn DeviceSnapShot);

	public List<DuplicateImeiMsisdn> saveAll(List<DuplicateImeiMsisdn> duplicateImeiMsisdns);
}
