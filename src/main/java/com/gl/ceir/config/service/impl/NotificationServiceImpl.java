/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.service.impl;

import com.gl.ceir.config.exceptions.InternalServicesException;
import com.gl.ceir.config.model.app.Notification;
import com.gl.ceir.config.model.constants.Alerts;
import com.gl.ceir.config.repository.app.NotificationRepository;
import com.gl.ceir.config.repository.app.OperatorSeriesRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maverick
 */
@Service
public class NotificationServiceImpl {

    private static final Logger logger = LogManager.getLogger(NotificationServiceImpl.class);

    @Autowired
    AlertServiceImpl alertServiceImpl;

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    OperatorSeriesRepository operatorSeriesRepository;

    public Object saveNotifications(Notification notification) {
        try {
            notification.setOperatorName(getActualOperator(notification.getMsisdn().substring(0, 5)));
            var value = notificationRepository.save(notification);
            logger.info(" Notification Saved" + value);
            return value;
        } catch (Exception e) {
            logger.error(" Exception occured " + e);
            alertServiceImpl.raiseAnAlert(Alerts.ALERT_1108.getName(), 0);
            throw new InternalServicesException(this.getClass().getName(), "internal server error");
        }
    }

    private String getActualOperator(String msisdn) {
        try {
            var value = operatorSeriesRepository.getBySeriesStartAndSeriesType(Integer.parseInt(msisdn.substring(0, 5)), "msisdn").getOperatorName();
            logger.info(" Actual operator  " + value);
            return value;
        } catch (Exception e) {
            logger.error("No operator Found:" + e);
            return "";
        }
    }
}
