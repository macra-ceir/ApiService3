package com.gl.ceir.config.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gl.ceir.config.model.app.modelRepoPojo;
import com.gl.ceir.config.service.impl.ModelServiceImpl;

//import io.swagger.annotations.ApiOperation;

@RestController
public class modelController {  ////sachin

     private static final Logger logger = LogManager.getLogger(modelController.class);

     @Autowired
     ModelServiceImpl modelServiceImpl;

     //@ApiOperation(value = "View All list of Mdels of Brands", response = modelRepoPojo.class)
     @RequestMapping(path = "gsma/modelName", method = RequestMethod.GET)
     public MappingJacksonValue getAllModels(@RequestParam("brand_id") int brand_id) {
          logger.info("Request TO view TO all record of user=" + brand_id);
          List<modelRepoPojo> getmodels = modelServiceImpl.getAll(brand_id);
          MappingJacksonValue mapping = new MappingJacksonValue(getmodels);
          logger.info("Response of View =" + mapping.toString() + "for id " + brand_id);
          return mapping;
     }
}
