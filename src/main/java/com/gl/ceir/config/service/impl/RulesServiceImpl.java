package com.gl.ceir.config.service.impl;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ceir.config.exceptions.ResourceServicesException;
import com.gl.ceir.config.repository.app.RulesRepository;

@Service
public class RulesServiceImpl {

    private static final Logger logger = LogManager.getLogger(RulesServiceImpl.class);

    @Autowired
    private RulesRepository rulesRepository;

//    public List<String> findDistinctByFeature() {
//        try {
////            List<RuleEngineMapping>  ftr = rulesRepository.findNonReferencedFeature();
//
//            List<String> str = rulesRepository.findDistinctFeature();
//            List<RuleEngineMapping> rem = new ArrayList<RuleEngineMapping>();
//
//            for (int i = 0; i < str.size(); i++) {
//                rem.
//            }
//
//            logger.info("Get All Names (Distinct) ");
//
//            return rulesRepository.findDistinctFeature();
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
//        }
//
//    }

     public List<String> findDistinctByFeature() {
        try {
            logger.info("Get All Names (Distinct) ");
            return rulesRepository.findDistinctFeature();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
        }
    }
}
