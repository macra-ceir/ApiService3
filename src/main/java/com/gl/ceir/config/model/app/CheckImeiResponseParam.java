package com.gl.ceir.config.model.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
// @Cacheable
//@Table(name = "check_imei_response")
public class CheckImeiResponseParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdOn;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date modifiedOn;

    private String tag;

    private String value;

    private String description;

    private Integer type; // have two values USER/SYSTEM.

    private String remark;

    private String featureName;

    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @NotNull
    private Integer active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    @Override
    public String toString() {
        return "CheckImeiResponseParam{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                ", tag='" + tag + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", remark='" + remark + '\'' +
                ", featureName='" + featureName + '\'' +
                ", language='" + language + '\'' +
                ", active=" + active +
                '}';
    }
}
