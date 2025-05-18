package com.gl.ceir.config.service;

import java.util.List;
import java.util.Map;

import com.gl.ceir.config.model.app.ActionParameters;
import com.gl.ceir.config.model.constants.ActionNames;
import com.gl.ceir.config.model.constants.ActionParametersName;

public interface ActionParametersService extends RestServices<ActionParameters> {
	public List<ActionParameters> findByAction(Long action_id);

	public List<ActionParameters> findByAction(String actionName);

	public Map<ActionNames, Map<ActionParametersName, String>> findAllWithMap();
}
