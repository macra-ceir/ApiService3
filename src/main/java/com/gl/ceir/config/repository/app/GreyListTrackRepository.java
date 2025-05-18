package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.GreylistDbHistory;

public interface GreyListTrackRepository extends JpaRepository<GreylistDbHistory, Long> , JpaSpecificationExecutor<GreylistDbHistory> {


	public GreylistDbHistory save(GreylistDbHistory greyListTracDetails);

}
