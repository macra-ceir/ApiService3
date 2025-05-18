package com.gl.ceir.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ceir.config.model.app.StackholderPolicyMapping;
import com.gl.ceir.config.service.impl.StackholderPolicyMappingServiceImpl;

//import io.swagger.annotations.ApiOperation;

@RestController
public class StakeHolderPolicyController {


	@Autowired
	StackholderPolicyMappingServiceImpl stackholderPolicyMappingServiceImpl;

	

	//@ApiOperation(value = "View Details of BlackList and Grey List", response = StackholderPolicyMapping.class)
	@RequestMapping(path = "/confifiguration/dumping", method = RequestMethod.GET)

	public MappingJacksonValue  viewListingDetails() {

		List<StackholderPolicyMapping> response =	stackholderPolicyMappingServiceImpl.getFileControllingDetails();

		MappingJacksonValue mapping = new MappingJacksonValue(response);

		return mapping;
	}





}
