package com.gl.ceir.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ceir.config.model.app.CheckDevice;
import com.gl.ceir.config.model.app.CheckDeviceReponse;
import com.gl.ceir.config.model.app.GenricResponse;
import com.gl.ceir.config.service.impl.CheckDeviceImpl;

 import io.swagger.annotations.ApiOperation;

@RestController
public class CheckDeviceController {

	@Autowired
	CheckDeviceImpl checkDeviceImpl;
	
	 @ApiOperation(value = "check device", response = GenricResponse.class)
	@PostMapping("checkDevice")
	public MappingJacksonValue checkDevice(@RequestBody CheckDevice checkDevice) {
		GenricResponse genricResponse=checkDeviceImpl.checkDevices(checkDevice);
        MappingJacksonValue mapping=new MappingJacksonValue(genricResponse);
		return mapping;
	}

}
