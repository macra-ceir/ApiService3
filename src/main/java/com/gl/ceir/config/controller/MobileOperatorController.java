package com.gl.ceir.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ceir.config.model.app.MobileOperator;
import com.gl.ceir.config.service.MobileOperatorService;

//import io.swagger.annotations.ApiOperation;

@RestController
public class MobileOperatorController {

	@Autowired
	private MobileOperatorService mobileOperatorService;

	//@ApiOperation(value = "View All available Mobile Operators", response = MobileOperator.class, responseContainer = "list")
	@RequestMapping(path = "/MobileOperators/", method = RequestMethod.GET)
	public MappingJacksonValue getAll() {
		List<MobileOperator> allOperators = mobileOperatorService.getAll();
		MappingJacksonValue mapping = new MappingJacksonValue(allOperators);
		return mapping;
	}

	//@ApiOperation(value = "View Mobile Operators by id", response = MobileOperator.class)
	@RequestMapping(path = "/MobileOperators/{id}", method = RequestMethod.GET)
	public MappingJacksonValue get(@PathVariable(value = "id") Long id) {
		MobileOperator operators = mobileOperatorService.get(id);
		MappingJacksonValue mapping = new MappingJacksonValue(operators);
		return mapping;
	}

	//@ApiOperation(value = "Save Mobile Operator", response = MobileOperator.class)
	@RequestMapping(path = "/MobileOperators/", method = RequestMethod.POST)
	public MappingJacksonValue save(@RequestBody MobileOperator mobileOperator) {
		MobileOperator savedOperators = mobileOperatorService.save(mobileOperator);
		MappingJacksonValue mapping = new MappingJacksonValue(savedOperators);
		return mapping;
	}

	//@ApiOperation(value = "Delete Mobile Operator", response = MobileOperator.class)
	@RequestMapping(path = "/MobileOperators/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id) {
		mobileOperatorService.delete(id);
	}

	//@ApiOperation(value = "Update Mobile Operator", response = MobileOperator.class)
	@RequestMapping(path = "/MobileOperators/{id}", method = RequestMethod.PUT)
	public MappingJacksonValue update(@PathVariable(value = "id") Long id, @RequestBody MobileOperator mobileOperator) {
		MobileOperator operators = mobileOperatorService.update(mobileOperator);
		MappingJacksonValue mapping = new MappingJacksonValue(operators);
		return mapping;
	}
}
