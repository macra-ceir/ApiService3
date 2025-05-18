package com.gl.ceir.config.service.impl;

import com.gl.ceir.config.repository.app.SystemConfigurationDbRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemParamServiceImpl {

    private static final Logger log = LogManager.getLogger(SystemParamServiceImpl.class);

    @Autowired
    SystemConfigurationDbRepository systemConfigurationDbRepositry;

    public String getValueByTag(String tag) {
        try {
            var value = systemConfigurationDbRepositry.getByTag(tag);
            if (value == null || StringUtils.isBlank(value.getValue())) {
                log.warn("No VALUE found for tag " + tag + "  ");
                return "";
            }
            log.info("Value for tag {} is  = {}", tag, value.getValue());
            return value.getValue();
        } catch (Exception e) {
            log.warn("No value found for tag " + tag + "# Error : " + e.toString());
            return null;
        }
    }
}
