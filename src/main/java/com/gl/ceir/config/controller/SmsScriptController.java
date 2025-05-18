package com.gl.ceir.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ceir.config.model.app.Script;
import com.gl.ceir.config.service.ScriptService;

@RestController
public class SmsScriptController {

	@Autowired
	private ScriptService smsScriptService;

	@RequestMapping(path = "/SmsScript/", method = RequestMethod.GET)
	public MappingJacksonValue getAll() {
		List<Script> allRules = smsScriptService.getAll();
		MappingJacksonValue mapping = new MappingJacksonValue(allRules);
		return mapping;
	}

	@RequestMapping(path = "/SmsScript/{id}", method = RequestMethod.GET)
	public MappingJacksonValue get(@PathVariable(value = "id") Long id) {
		Script smsScript = smsScriptService.get(id);
		MappingJacksonValue mapping = new MappingJacksonValue(smsScript);
		return mapping;
	}

	@RequestMapping(path = "/SmsScript/", method = RequestMethod.POST)
	public MappingJacksonValue save(@RequestBody Script smsScript) {
		Script savedSmsScript = smsScriptService.save(smsScript);
		MappingJacksonValue mapping = new MappingJacksonValue(savedSmsScript);
		return mapping;
	}

	@RequestMapping(path = "/SmsScript/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id) {
		smsScriptService.delete(id);
	}

	@RequestMapping(path = "/SmsScript/{id}", method = RequestMethod.PUT)
	public MappingJacksonValue update(@PathVariable(value = "id") Long id, @RequestBody Script smsScript) {
		Script updateSmsScript = smsScriptService.update(smsScript);
		MappingJacksonValue mapping = new MappingJacksonValue(updateSmsScript);
		return mapping;
	}
}
