/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.model.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author maverick
 */
@Entity
@Getter
@Setter
// @Table(name = "mobile_device_repository")
public class NationalWhitelist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String imei;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdOn;

    private String actualImei;
    private String msisdn;
    private String mobileOperator;

    private String listType;

    private String typeOfEntry;

    private LocalDateTime nationalWhiteListCreatedDate;

}
