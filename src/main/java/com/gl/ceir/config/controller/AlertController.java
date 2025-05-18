/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.controller;

import com.gl.ceir.config.service.impl.AlertServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ceir.config.model.app.AlertRequest;

@RestController
public class AlertController {

    @Autowired
    private AlertServiceImpl alertServiceImpl;

    @RequestMapping(path = "/alert/{id}", method = RequestMethod.GET)
    public MappingJacksonValue raiseAlertById(@PathVariable(value = "id") String id) {
        var response = alertServiceImpl.raiseAlertById(id);
        return new MappingJacksonValue(response);
    }

    @PostMapping("/alert")
    public MappingJacksonValue save(@RequestBody AlertRequest alertRequest) {
        var action = alertServiceImpl.saveAlertWithParam(alertRequest);
        return new MappingJacksonValue(action);
    }
    
   
    
}
