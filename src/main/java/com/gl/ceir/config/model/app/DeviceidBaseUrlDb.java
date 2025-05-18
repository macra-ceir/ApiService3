/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.model.app;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author maverick
 */
@Entity

@Getter
@Setter
@ToString
@Table(name = "preinit_deviceid_baseurl")
public class DeviceidBaseUrlDb implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    @CreationTimestamp
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//    private LocalDateTime createdOn;
 @Id
    private String deviceId;

    private String baseUrl;


}
