/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.CheckImeiRequest;

public interface CheckImeiRequestRepository extends JpaRepository<CheckImeiRequest, Long>, JpaSpecificationExecutor<CheckImeiRequest> {

    public CheckImeiRequest save(CheckImeiRequest checkImeiRequest);

}
