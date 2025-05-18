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
import javax.persistence.Transient;

@Table(name = "gsma_tac_db")
@Entity
public class RuleEngineMappinCop implements Serializable {

    @Id
    
    private Long id;

    @Column
    private String feature;

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
