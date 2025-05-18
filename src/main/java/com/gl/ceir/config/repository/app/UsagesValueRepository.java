package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.UsagesValueModel; 



public interface UsagesValueRepository extends JpaRepository<UsagesValueModel, Long>, JpaSpecificationExecutor<UsagesValueModel> {

     public UsagesValueModel getByMsisdn(String msisdn);

     public UsagesValueModel getByImei(String imei);

     public UsagesValueModel getByImeiAndMsisdn(String imei, String msisdn);

}
