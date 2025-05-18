package com.gl.ceir.config.controller;

import com.gl.ceir.config.service.impl.BrandServiceImpl;
//import io.swagger.annotations.ApiOperation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController { //sachin

    
    @Autowired
    BrandServiceImpl brandServiceImpl ;
    
    private static final Logger logger = LogManager.getLogger(BrandController.class);

    //@ApiOperation(value = "View All list of Brands", response = String.class)
    @RequestMapping(path = "gsma/brandName", method = RequestMethod.GET)
    public MappingJacksonValue getAllBrands() {
        var getBrands =brandServiceImpl.getAllBrands();
        MappingJacksonValue mapping = new MappingJacksonValue(getBrands);
        return mapping;
    }
}
