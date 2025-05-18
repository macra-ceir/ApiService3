package com.gl.ceir.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ceir.config.model.app.MediationSource;
import com.gl.ceir.config.service.MediationSourceService;

@RestController
public class MediationSourceController {

	@Autowired
	private MediationSourceService mediationSourceService;

	@RequestMapping(path = "/MediationSource/", method = RequestMethod.GET)
	public MappingJacksonValue getAll() {
		List<MediationSource> allOperators = mediationSourceService.getAll();
		MappingJacksonValue mapping = new MappingJacksonValue(allOperators);
		return mapping;
	}

	@RequestMapping(path = "/MediationSource/{id}", method = RequestMethod.GET)
	public MappingJacksonValue get(@PathVariable(value = "id") Long id) {
		MediationSource mediationSource = mediationSourceService.get(id);
		MappingJacksonValue mapping = new MappingJacksonValue(mediationSource);
		return mapping;
	}

	@RequestMapping(path = "/MediationSource/", method = RequestMethod.POST)
	public MappingJacksonValue save(@RequestBody MediationSource mediationSource) {
		MediationSource savedMediationSource = mediationSourceService.save(mediationSource);
		MappingJacksonValue mapping = new MappingJacksonValue(savedMediationSource);
		return mapping;
	}

	@RequestMapping(path = "/MediationSource/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id) {
		mediationSourceService.delete(id);
	}

	@RequestMapping(path = "/MediationSource/{id}", method = RequestMethod.PUT)
	public MappingJacksonValue update(@PathVariable(value = "id") Long id,
			@RequestBody MediationSource mediationSource) {
		MediationSource updatedMediationSource = mediationSourceService.update(mediationSource);
		MappingJacksonValue mapping = new MappingJacksonValue(updatedMediationSource);
		return mapping;
	}
}
