package com.gl.ceir.config.controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ceir.config.service.impl.RulesServiceImpl;
//import io.swagger.annotations.ApiOperation; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class RulesController { //sachin

    @Autowired
            RulesServiceImpl rulesServiceImpl;
    
    //@ApiOperation(value = "Get All Distinct Rule Feature Name :", response = List.class)
     @RequestMapping(path = "Rule/DistinctName", method = RequestMethod.GET)
    public MappingJacksonValue getAll() {
        List<String> allRules = rulesServiceImpl.findDistinctByFeature();
        MappingJacksonValue mapping = new MappingJacksonValue(allRules);
        return mapping;
    }
    
    
    
    
    
//     //@ApiOperation(value = "Get All Distinct Rule Feature Name :", response = List.class)
//     @RequestMapping(path = "Rule/DistinctName", method = RequestMethod.GET)
//     public MappingJacksonValue getAll() {
//        List<String> allRules = rulesServiceImpl.findDistinctByFeature();
//        MappingJacksonValue mapping = new MappingJacksonValue(allRules);
//        return mapping;
//    }
 
}

