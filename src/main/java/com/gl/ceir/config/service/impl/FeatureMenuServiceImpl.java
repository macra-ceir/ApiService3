package com.gl.ceir.config.service.impl;

import com.gl.ceir.config.model.app.FeatureMenu;
import com.gl.ceir.config.repository.app.FeatureMenuRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FeatureMenuServiceImpl {

    @Autowired
    FeatureMenuRepository featureMenuRepository;

    private final Logger logger = LogManager.getLogger(this.getClass());

    public List<FeatureMenu> getAll() {
        try {
            var v = featureMenuRepository.findAll();
            logger.info("Response {}", v.toString());
            return v;
        } catch (Exception e) {
            logger.error("Exp::: : " + e.getMessage() + " : " + e.getLocalizedMessage());
            return null;
        }
    }
}
