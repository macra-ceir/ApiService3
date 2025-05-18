/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.service.impl;

import com.gl.ceir.config.exceptions.InternalServicesException;
import com.gl.ceir.config.model.app.FeatureMenu;
import com.gl.ceir.config.model.app.LanguageResponse;
import com.gl.ceir.config.model.constants.Alerts;
import com.gl.ceir.config.repository.app.LanguageLabelDbRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author maverick
 */
@Service
public class LanguageServiceImpl {

    private static final Logger logger = LogManager.getLogger(LanguageServiceImpl.class);

    @Autowired
    LanguageLabelDbRepository languageLabelDbRepository;

    @Autowired
    AlertServiceImpl alertServiceImpl;

    @Autowired
    FeatureMenuServiceImpl featureMenuServiceImpl;

    public LanguageResponse getLanguageLabels(String featureName, String language) {
        String responseValue;
        logger.info("Feature Name " + featureName);
        try {
            if (language.contains("kh")) {
                responseValue = languageLabelDbRepository.getKhmerNameAndLabelFromFeatureName(featureName);
            } else {
                responseValue = languageLabelDbRepository.getEnglishNameAndLabelFromFeatureName(featureName);
            }
            List<FeatureMenu> s = featureMenuServiceImpl.getAll();

            return new LanguageResponse(language, (JSONObject) new JSONParser().parse(responseValue), s);
        } catch (Exception e) {
            logger.error(e + " : " + e.getLocalizedMessage());
            alertServiceImpl.raiseAnAlert(Alerts.ALERT_1105.getName(), 0);
            throw new InternalServicesException("en", e.getLocalizedMessage());
        }
    }

//    public LanguageResponse getLanguageLabels1(String featureName, String language) {
//        String responseValue;
//        try {
//            if (language.contains("kh")) {
//                responseValue = languageLabelDbRepository.getKhmerNameAndLabelFromFeatureName(featureName);
//            } else {
//                responseValue = languageLabelDbRepository.getEnglishNameAndLabelFromFeatureName(featureName);
//            }
//            logger.info("Value " + responseValue);
//
//            JsonObject jo = JsonParser.parseString(responseValue).getAsJsonObject();
//
//            logger.info("JsonObject " + jo);
//
//            return new LanguageResponse(language, jo);
//
////            var n1 = new JSONParser().parse(responseValue);
////            logger.info("n1 " + n1);
////            var n2 = (JSONObject) n1;
////            logger.info("n2 " + n2);
//
//            //  return new LanguageResponse(language, (JSONObject) new JSONParser().parse(responseValue));
//        } catch (Exception e) {
//            logger.error(e + " : " + e.getLocalizedMessage());
//            alertServiceImpl.raiseAnAlert(Alerts.ALERT_1105.getName(), 0);
//            throw new InternalServicesException("en", e.getLocalizedMessage());
//        }
//    }

}
