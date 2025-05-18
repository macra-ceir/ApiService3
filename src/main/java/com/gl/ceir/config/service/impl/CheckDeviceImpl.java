package com.gl.ceir.config.service.impl;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gl.ceir.config.model.app.CheckDevice;
import com.gl.ceir.config.model.app.CheckDeviceReponse;
import com.gl.ceir.config.model.app.GenricResponse;
@Service
public class CheckDeviceImpl {

	public GenricResponse checkDevices( CheckDevice checkDevice) {
		   CheckDeviceReponse checkDeviceResponse=new CheckDeviceReponse();
	        checkDeviceResponse.setBrandName("Redmi");
	        checkDeviceResponse.setModelName("Ac11");
	        checkDeviceResponse.setTacNumber("476433753");
	        Object data=checkDeviceResponse;
	        GenricResponse response=new GenricResponse(200,"The IMEI number is valid","",data);
	        return response;
	}
}
