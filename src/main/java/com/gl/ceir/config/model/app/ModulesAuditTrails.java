package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
@ToString
@Table(name = "modules_audit_trail")

//@DynamicInsert
public class ModulesAuditTrails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @CreationTimestamp
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//    private LocalDateTime createdOn;
//
//    @UpdateTimestamp
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//    private LocalDateTime modifiedOn;
    private int executionTime;
    private String statusCode;

    private String status;

    private String errorMessage;
    private String moduleName;
    private String featureName;
    // private String action;
    private String info;
    private String serverName;

//    private int count2;
    private int count;



}
