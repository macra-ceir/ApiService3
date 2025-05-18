package com.gl.ceir.config.service.impl;

import com.gl.ceir.config.model.app.CheckImeiResponseParam;
import com.gl.ceir.config.repository.app.CheckImeiResponseParamRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CheckImeiResponseParamRepoImpl {
    private static final Logger logger = LogManager.getLogger(CheckImeiResponseParamRepoImpl.class);

    @Autowired
    CheckImeiResponseParamRepository chkImeiRespPrmRepo;

    public List<CheckImeiResponseParam> cachedData;
    private boolean updatedNeeded = false;

    @PostConstruct
    public void loadData() {
        updateCachedData();
    }

    public String getValueByTagAndLanguage(String tag, String language) {
        var result = getCachedData().stream()
                .filter(t -> t.getTag().equalsIgnoreCase(tag) && t.getLanguage().equalsIgnoreCase(language))
                .map(t -> t.getValue())
                .findFirst();
        logger.info("For tag " + tag + "^" + language + "==Result :" + result);
        return String.valueOf(result);
    }

    public List<CheckImeiResponseParam> getCachedData() {
        if (updatedNeeded) {
            updateCachedData();
        }
        return cachedData;
    }


    public void setUpdatedNeeded(boolean updatedNeeded) {
        this.updatedNeeded = updatedNeeded;
    }

    private synchronized void updateCachedData() {
        cachedData = chkImeiRespPrmRepo.findAll();
        updatedNeeded = false;
    }

}

