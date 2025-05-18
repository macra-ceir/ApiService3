/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.service;

import com.gl.ceir.config.repository.audit.ModulesAuditTrailRepository;
import com.gl.ceir.config.model.audit.ModulesAuditTrail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maverick
 */
@Service
public class ModulesAuditTrailService {

//    @Autowired
//    ModulesAuditTrailRepository auditRepo;

    private final Logger logger = LogManager.getLogger(getClass());

    public ModulesAuditTrail save() {
        try {
            ModulesAuditTrail moduleTrail = new ModulesAuditTrail(200, "Success", "", "Apiservice3", "CheckImei", "Testing Purpose", "Server1", 5, 10);
            logger.info("Going to save in audit db ");
            return null;
          //  return auditRepo.save(moduleTrail);
        } catch (Exception e) {
            logger.error("Error occurs when saving  Message data in db  " + e.getLocalizedMessage());

            return null;
        }
    }

}
