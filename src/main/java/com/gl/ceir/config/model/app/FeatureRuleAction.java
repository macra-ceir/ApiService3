/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.ceir.config.model.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author maverick
 */
 
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
//


@Table(name = "feature_rule_action")
@Entity
public class FeatureRuleAction implements Serializable {

     private static final long serialVersionUID = 1L;

     @Id
     private int id;
     private String ruleName;
     private String featureName;
     private String actions;
  	
     
	@CreationTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime createdOn;
	
	@UpdateTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime modifiedOn;

     public FeatureRuleAction(int id, String ruleName, String featureName, String actions, LocalDateTime createdOn, LocalDateTime modifiedOn) {
          this.id = id;
          this.ruleName = ruleName;
          this.featureName = featureName;
          this.actions = actions;
          this.createdOn = createdOn;
          this.modifiedOn = modifiedOn;
     }

     
     public FeatureRuleAction() {
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getRuleName() {
          return ruleName;
     }

     public void setRuleName(String ruleName) {
          this.ruleName = ruleName;
     }

     public String getFeatureName() {
          return featureName;
     }

     public void setFeatureName(String featureName) {
          this.featureName = featureName;
     }

     public String getActions() {
          return actions;
     }

     public void setActions(String actions) {
          this.actions = actions;
     }

     public LocalDateTime getCreatedOn() {
          return createdOn;
     }

     public void setCreatedOn(LocalDateTime createdOn) {
          this.createdOn = createdOn;
     }

     public LocalDateTime getModifiedOn() {
          return modifiedOn;
     }

     public void setModifiedOn(LocalDateTime modifiedOn) {
          this.modifiedOn = modifiedOn;
     }

     @Override
     public String toString() {
          return "RuleFeatureActionMapping{" + "id=" + id + ", ruleName=" + ruleName + ", featureName=" + featureName + ", actions=" + actions + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + '}';
     }
 
}
