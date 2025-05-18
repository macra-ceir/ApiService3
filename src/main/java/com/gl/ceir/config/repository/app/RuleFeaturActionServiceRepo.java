/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.ceir.config.repository.app;
 
import com.gl.ceir.config.model.app.FeatureRuleAction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author maverick
 */
 



public  interface RuleFeaturActionServiceRepo extends JpaRepository<FeatureRuleAction, Long>, JpaSpecificationExecutor<FeatureRuleAction>  {

 
     @Query("select distinct featureName from FeatureRuleAction where ruleName = ?1 ")
     public List<String> getByRuleName(String ruleName );

     @Query("select distinct ruleName from FeatureRuleAction where featureName = ?1 ")
     public List<String> getByFeatureName(String featureName);

     public List<FeatureRuleAction> getByFeatureNameAndRuleName(String featureName, String ruleName);



	

}
