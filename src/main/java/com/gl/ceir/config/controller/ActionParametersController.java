package com.gl.ceir.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ceir.config.model.app.ActionParameters;
import com.gl.ceir.config.service.ActionParametersService;

//import io.swagger.annotations.ApiOperation;

@RestController
public class ActionParametersController {

	@Autowired
	private ActionParametersService actionParametersService;

	//@ApiOperation(value = "View All available Action Parameters", response = ActionParameters.class, responseContainer = "list")

	@RequestMapping(path = "/ActionParameters/", method = RequestMethod.GET)
	public MappingJacksonValue getAll() {
		List<ActionParameters> actionParameters = actionParametersService.getAll();
		MappingJacksonValue mapping = new MappingJacksonValue(actionParameters);
		return mapping;
	}

	// @RequestMapping(path = "/ActionParameters/{action_id}", method =
	// RequestMethod.GET)
	public MappingJacksonValue get(@PathVariable(value = "action_id") Long action_id) {
		List<ActionParameters> actionParameters = actionParametersService.findByAction(action_id);
		MappingJacksonValue mapping = new MappingJacksonValue(actionParameters);
		return mapping;
	}

	//@ApiOperation(value = "View All available Action Parameters of particular Action Name (USER_REGULARIZED / SYSTEM_REGULARIZED)", response = ActionParameters.class, responseContainer = "list")
	@RequestMapping(path = "/ActionParameters/{action_name}", method = RequestMethod.GET)
	public MappingJacksonValue get(@PathVariable(value = "action_name") String action) {
		List<ActionParameters> actionParameters = actionParametersService.findByAction(action);
		MappingJacksonValue mapping = new MappingJacksonValue(actionParameters);
		return mapping;
	}

	// @RequestMapping(path = "/ActionParameters/", method = RequestMethod.POST)
	public MappingJacksonValue save(@RequestBody ActionParameters actionParameters) {
		ActionParameters savedActionParameters = actionParametersService.save(actionParameters);
		MappingJacksonValue mapping = new MappingJacksonValue(savedActionParameters);
		return mapping;
	}

	// @RequestMapping(path = "/ActionParameters/{id}", method =
	// RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id) {
		actionParametersService.delete(id);
	}

	// @RequestMapping(path = "/ActionParameters/{id}", method = RequestMethod.PUT)
	public MappingJacksonValue update(@RequestBody ActionParameters actionParameters) {
		ActionParameters updatedActionParameters = actionParametersService.update(actionParameters);
		MappingJacksonValue mapping = new MappingJacksonValue(updatedActionParameters);
		return mapping;
	}
}
