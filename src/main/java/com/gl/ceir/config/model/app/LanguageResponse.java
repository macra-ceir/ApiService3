/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.model.app;

// import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

import java.util.List;
//import springfox.documentation.spring.web.json.Json;

/**
 *
 * @author maverick
 */
/// response might has some annotation for default
@Getter
@Setter
public class LanguageResponse {

    private String languageType;
    private JSONObject labelDetails;
private List<FeatureMenu> featureMenu;

    public LanguageResponse(String languageType, JSONObject labelDetails  , List<FeatureMenu> featureMenu) {
        this.languageType = languageType;
        this.labelDetails = labelDetails;
        this.featureMenu=featureMenu;
    }

}
