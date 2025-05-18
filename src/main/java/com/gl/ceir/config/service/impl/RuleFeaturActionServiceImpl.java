/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.ceir.config.service.impl;

import com.gl.ceir.config.exceptions.ResourceServicesException;
import com.gl.ceir.config.model.app.FeatureRuleAction;
import com.gl.ceir.config.repository.app.RuleFeaturActionServiceRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author maverick
 */


@Service
public class RuleFeaturActionServiceImpl {

     private static final Logger logger = LogManager.getLogger(RuleFeaturActionServiceImpl.class);

     @Autowired
     RuleFeaturActionServiceRepo ruleFeaturActionServiceRepo;

     public List<String> getfeaturebyRuleName(String RULE_NAME) {
          try {
               logger.info(" getfeaturebyRuleName " + RULE_NAME);
               return ruleFeaturActionServiceRepo.getByRuleName(RULE_NAME);
          } catch (Exception e) {
               logger.error(e.getMessage(), e);
               throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
          }

     }

     public List<String> getRulebyFeatureName(String FEATURE_NAME) {
          try {
               logger.info("getRulebyFeatureName " + FEATURE_NAME);
               return ruleFeaturActionServiceRepo.getByFeatureName(FEATURE_NAME);
          } catch (Exception e) {
               logger.error(e.getMessage(), e);
               throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
          }
     }

     public List<FeatureRuleAction> getactionbyRuleFeature(String ruleName, String feature) {
          try {
               logger.info("getactionbyRuleFeature " + ruleName + " :: " + feature);
               return ruleFeaturActionServiceRepo.getByFeatureNameAndRuleName(feature, ruleName);
          } catch (Exception e) {
               logger.error(e.getMessage(), e);
               throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
          }
     }

}
