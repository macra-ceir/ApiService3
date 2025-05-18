/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.DeviceidBaseUrlDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author maverick
 */
public interface CheckImeiPreInitRepository extends JpaRepository<DeviceidBaseUrlDb, Long>, JpaSpecificationExecutor<DeviceidBaseUrlDb> {

    public DeviceidBaseUrlDb getByDeviceId(String deviceId);
}

