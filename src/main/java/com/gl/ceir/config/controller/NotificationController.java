/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.controller;

import com.gl.ceir.config.model.app.Notification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RestController;
import com.gl.ceir.config.service.impl.NotificationServiceImpl;

//import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class NotificationController {//sachin

    private static final Logger logger = LogManager.getLogger(NotificationController.class);
    @Autowired
    private NotificationServiceImpl notificationServiceImpl;

    //@ApiOperation(value = "Save all Notifications", response = String.class)
    @PostMapping("addNotifications")
    public MappingJacksonValue addNotifications(@RequestBody Notification notification) {
        logger.info("Notification Request " + notification.toString());
        MappingJacksonValue mapping = new MappingJacksonValue(notificationServiceImpl.saveNotifications(notification));
        logger.info("Response of View =" + mapping);
        return mapping;
    }

}
