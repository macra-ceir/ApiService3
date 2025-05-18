/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.DuplicateValueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface DuplicateValueRepository extends JpaRepository<DuplicateValueModel, Long>, JpaSpecificationExecutor<DuplicateValueModel> {

     public DuplicateValueModel getByImeiAndMsisdn(String imei, String msisdn);
}
