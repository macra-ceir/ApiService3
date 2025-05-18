package com.gl.ceir.config.service.impl;

import com.gl.ceir.config.repository.app.EirsResponseParamRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EirsResponseParamServiceImpl {

    private static final Logger log = LogManager.getLogger(EirsResponseParamServiceImpl.class);

    @Autowired
    EirsResponseParamRepository eir;

    public String getValueByTag(String tag) {
        try {
            var value = eir.getByTag(tag);
            if (value == null || StringUtils.isBlank(value.getValue())) {
                log.warn("No value found for tag " + tag + "  ");
                return "";
            }
            log.info("Value for  tag {} is  = {}", tag, value);
            return value.getValue();
        } catch (Exception e) {
            log.warn("No value found for tag {} # Error : {}", tag, e.toString());
            return null;
        }
    }
}
