package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ceir.config.model.app.Action;
import com.gl.ceir.config.model.constants.ActionNames;


public interface ActionRepository extends JpaRepository<Action, Long> {

	public Action findByName(ActionNames name);

}

