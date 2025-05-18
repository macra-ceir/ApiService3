package com.gl.ceir.config.model.app;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "dev_brand_name")
public class DevBrandName implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // brand_name is used by GUI not brandName
    private String brand_name;

    public DevBrandName(int id, String brand_name) {
        this.id = id;
        this.brand_name = brand_name;
    }


    public DevBrandName() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    @Override
    public String toString() {
        return "DevBrandName{" + "id=" + id + ", brand_name=" + brand_name + '}';
    }

}
