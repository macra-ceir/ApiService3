/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.model.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author maverick
 */
@Getter
@Setter
@AllArgsConstructor
@ToString

public class AlertRequest {

    String alertId;
    String alertMessage;
    String alertProcess;
    int userId;

}
