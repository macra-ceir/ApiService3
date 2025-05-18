package com.gl.ceir.config.model.app;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


import io.swagger.annotations.ApiModel;
import javax.persistence.Table;

@ApiModel
@Entity
@Table(name = "feature_rule")
public class RuleEngineMapping implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 20)
    public String feature;

    @Column
    private String name;

    @NotNull
    @Column(length = 20)
    private String graceAction;

    @NotNull
    @Column(length = 20)
    private String postGraceAction;

    @NotNull
    private Integer ruleOrder;

    @NotNull
    @Column(length = 20)
    private String userType;

    @Column(length = 20)
    private String output;

    @Column
    private String ruleMessage;

    public String getRuleMessage() {
        return ruleMessage;
    }

    public void setRuleMessage(String ruleMessage) {
        this.ruleMessage = ruleMessage;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getGraceAction() {
        return graceAction;
    }

    public void setGraceAction(String graceAction) {
        this.graceAction = graceAction;
    }

    public String getPostGraceAction() {
        return postGraceAction;
    }

    public void setPostGraceAction(String postGraceAction) {
        this.postGraceAction = postGraceAction;
    }

    public Integer getRuleOrder() {
        return ruleOrder;
    }

    public void setRuleOrder(Integer ruleOrder) {
        this.ruleOrder = ruleOrder;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RuleEngineMapping{id=").append(id);
        sb.append(", feature=").append(feature);
        sb.append(", name=").append(name);
        sb.append(", graceAction=").append(graceAction);
        sb.append(", postGraceAction=").append(postGraceAction);
        sb.append(", ruleOrder=").append(ruleOrder);
        sb.append(", userType=").append(userType);
        sb.append(", output=").append(output);
        sb.append(", ruleMessage=").append(ruleMessage);
        sb.append('}');
        return sb.toString();
    }

}

