package com.gl.ceir.config.service.impl;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ceir.config.exceptions.ResourceNotFoundException;
import com.gl.ceir.config.exceptions.ResourceServicesException;
import com.gl.ceir.config.model.app.MediationSource;
import com.gl.ceir.config.repository.app.MediationSourceRepository;
import com.gl.ceir.config.service.MediationSourceService;

@Service
public class MediationSourceServiceImpl implements MediationSourceService {

	private static final Logger logger = LogManager.getLogger(MediationSourceService.class);

	@Autowired
	private MediationSourceRepository mediationSourceRepository;

	@Override
	public List<MediationSource> getAll() {
		try {
			return mediationSourceRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}

	}

	@Override
	public MediationSource save(MediationSource mediationSource) {

		try {
			return mediationSourceRepository.save(mediationSource);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}
	}

	@Override
	public MediationSource get(Long id) {

		try {
			MediationSource mediationSource = mediationSourceRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Mediation Source", "id", id));
			return mediationSource;
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}
	}

	@Override
	public MediationSource update(MediationSource mediationSource) {

		try {
			return mediationSourceRepository.save(mediationSource);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}
	}

	@Override
	public void delete(Long id) {

		try {
			mediationSourceRepository.deleteById(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}
	}

}
