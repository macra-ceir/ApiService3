package com.gl.ceir.config.service.impl;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ceir.config.exceptions.ResourceNotFoundException;
import com.gl.ceir.config.exceptions.ResourceServicesException;
import com.gl.ceir.config.model.app.MobileOperator;
import com.gl.ceir.config.repository.app.MobileOperatorRepository;
import com.gl.ceir.config.service.MobileOperatorService;

@Service
public class MobileOperatorServiceImpl implements MobileOperatorService {

	private static final Logger logger = LogManager.getLogger(MobileOperatorServiceImpl.class);

	@Autowired
	private MobileOperatorRepository mobileOperatorRepository;

	@Override
	public List<MobileOperator> getAll() {
		try {
			return mobileOperatorRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}

	}

	@Override
	public MobileOperator save(MobileOperator mobileOperator) {

		try {
			// TODO Auto-generated method stub
			return mobileOperatorRepository.save(mobileOperator);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}
	}

	@Override
	public MobileOperator get(Long id) {
		try {
			MobileOperator mobileOperator = mobileOperatorRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Mobile Operator", "id", id));
			return mobileOperator;
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}
	}

	@Override
	public void delete(Long id) {

		try {
			logger.info("Delete Mobile Operatot for id :" + id);
			mobileOperatorRepository.deleteById(id);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			logger.info("Delete Mobile Operatot for id :" + id + " Not Exist in table");
			throw new ResourceNotFoundException("Mobile Operator", "id", id);

		} catch (Exception e) {
			logger.info("Exception Delete Mobile Operatot for id :" + id);
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}
	}

	@Override
	public MobileOperator update(MobileOperator t) {

		try {
			return mobileOperatorRepository.save(t);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}
	}

}
