package com.gl.ceir.config.service.impl;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ceir.config.exceptions.ResourceNotFoundException;
import com.gl.ceir.config.exceptions.ResourceServicesException;
import com.gl.ceir.config.model.app.Action;
import com.gl.ceir.config.repository.app.ActionRepository;
import com.gl.ceir.config.service.ActionService;

@Service
public class ActionServiceImpl implements ActionService {

	@Autowired
	private ActionRepository actionRepository;

	private static final Logger logger = LogManager.getLogger(ActionServiceImpl.class);

	@Override
	public List<Action> getAll() {
		try {
			return actionRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException("ActionServiceImpl", e.getMessage());
		}

	}

	@Override
	public Action save(Action action) {
		try {
			return actionRepository.save(action);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException("ActionServiceImpl", e.getMessage());
		}

	}

	@Override
	public Action get(Long id) {

		try {
			Action action = actionRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Action", "id", id));
			return action;
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException("ActionServiceImpl", e.getMessage());
		}
	}

	@Override
	public Action update(Action action) {
		try {
			return actionRepository.save(action);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException("ActionServiceImpl", e.getMessage());
		}

	}

	@Override
	public void delete(Long id) {
		try {
			actionRepository.deleteById(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException("ActionServiceImpl", e.getMessage());
		}
	}

}
