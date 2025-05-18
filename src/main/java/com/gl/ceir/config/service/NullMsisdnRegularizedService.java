package com.gl.ceir.config.service;

import java.util.List;

import com.gl.ceir.config.model.app.NullMsisdnRegularized;

public interface NullMsisdnRegularizedService {
	public NullMsisdnRegularized get(Long msisdn);
	
	public NullMsisdnRegularized save(NullMsisdnRegularized nullMsisdnRegularized);

	public List<NullMsisdnRegularized> saveAll(List<NullMsisdnRegularized> nullMsisdnRegularizeds);
}
