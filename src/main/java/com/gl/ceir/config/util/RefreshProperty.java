/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.util;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

/**
 *
 * @author maverick
 */
@Service

//@Configuration

public class RefreshProperty {

    @Value("#{'${Top5Brands}'.split(',')}")
    private List<String> top5Brands;

    public List<String> getTop5Brands() {
        return top5Brands;
    }

}
