package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.gl.ceir.config.model.app.AppDeviceDetailsDb;
import javax.transaction.Transactional;

public interface AppDeviceDetailsRepository extends JpaRepository<AppDeviceDetailsDb, Long>, JpaSpecificationExecutor<AppDeviceDetailsDb> {

    @Query(value = "select  distinct(os_type)  from  mobile_app_dev_info where device_id = :device_id limit 1", nativeQuery = true)
    public String getByDeviceId(String device_id);

    @Modifying
    @Query(value = "insert into mobile_app_dev_info (os_type,device_id,device_details,language_type)   VALUES (:osType,:deviceId  ,:deviceDetails , :languageType)", nativeQuery = true)
    @Transactional
    void saveDetails(@Param("osType") String osType, @Param("deviceId") String deviceId, @Param("deviceDetails") String deviceDetails, @Param("languageType") String languageType);

}
