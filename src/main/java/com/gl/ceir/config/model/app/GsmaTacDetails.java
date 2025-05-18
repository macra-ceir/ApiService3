package com.gl.ceir.config.model.app;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "mobile_device_repository")
public class GsmaTacDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String deviceId;
    private String brand_name;
    private String model_name;
    private String device_type;
    private String marketing_name;
    private String manufacturer;

}
