package com.gl.ceir.config.controller;

import com.gl.ceir.config.dto.DeliveryInfoNotification;
import com.gl.ceir.config.dto.DeliveryInfoNotificationDto;
import com.gl.ceir.config.model.constants.DeliveryStatus;
import com.gl.ceir.config.model.app.Notification;
import com.gl.ceir.config.repository.app.NotificationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/callback")
public class CallbackController {

    private static final Logger logger = LogManager.getLogger(CallbackController.class);

    @Autowired
    NotificationRepository notificationRepository;

    @RequestMapping(path = "/kanel", method = RequestMethod.GET)
    public ResponseEntity<String> kanelCallback(@RequestParam(required = true) String myId, @RequestParam(required = true) String operatorName, @RequestParam(required = true) String answer, @RequestParam(required = true) Integer status, @RequestParam(required = true) Long dlrvTime){
        try {
            LocalDateTime deliveryTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(dlrvTime), ZoneId.systemDefault());
            logger.info("Callback from kanel: operatorName: "+operatorName+", answer: "+answer+", corelationId: "+myId+", status: "+ DeliveryStatus.fromValue(status)+", deliveryTime: "+deliveryTime);
            Notification noti = notificationRepository.findByCorelationIdAndOperatorName(myId, operatorName);
            if(noti != null) {
//                noti.setDeliveryTime(deliveryTime);
                noti.setDeliveryStatus(DeliveryStatus.fromValue(status));
                notificationRepository.save(noti);
            }
            return new ResponseEntity<String>("OK", HttpStatus.OK);
        } catch (Exception e) {
            logger.info("Exception in kanel callback api: "+e);
            return new ResponseEntity<String>("Request Failed. Please try again later", HttpStatus.SERVICE_UNAVAILABLE);
        }

    }

    @RequestMapping(path = "/smart", method = RequestMethod.POST)
    public ResponseEntity<String> smartCallback(@RequestBody DeliveryInfoNotificationDto deliveryInfoNotificationDto){
        try {
            logger.info("Callback from smart: "+ deliveryInfoNotificationDto.toString());
            DeliveryInfoNotification deliveryInfoNotification = deliveryInfoNotificationDto.getDeliveryInfoNotification();
            if (deliveryInfoNotification != null && deliveryInfoNotification.getDeliveryInfo() != null && deliveryInfoNotification.getDeliveryInfo().getDeliveryStatus() != null && deliveryInfoNotification.getDeliveryInfo().getAddress() != null) {
                String deliveryStatus = deliveryInfoNotification.getDeliveryInfo().getDeliveryStatus();
                String msisdn = deliveryInfoNotification.getDeliveryInfo().getAddress().replace("tel:+", "");
                logger.info("deliveryStatus: " + deliveryStatus + ", deliveryAddress: " + msisdn + ", corelationId: "+ deliveryInfoNotificationDto.getDeliveryInfoNotification().getCallbackData());
                Notification noti = notificationRepository.findByCorelationIdAndOperatorName(deliveryInfoNotificationDto.getDeliveryInfoNotification().getCallbackData(), "smart");
                if(noti != null) {
//                    noti.setDeliveryTime(LocalDateTime.now());
                    noti.setDeliveryStatus(deliveryStatus);
                    notificationRepository.save(noti);
                }
                return new ResponseEntity<String>("OK", HttpStatus.OK);
            } else {
                System.out.println("Delivery status not found or null");
                return new ResponseEntity<String>("Delivery status not found or null", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            logger.info("Exception in smart callback api: {}"+e);
            return new ResponseEntity<String>("Request Failed. Please try again later", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    public static LocalDateTime unixTimeToLocalDateTime(long unixTime) {
        Instant instant = Instant.ofEpochSecond(unixTime);
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTime), ZoneId.systemDefault());
    }
}
