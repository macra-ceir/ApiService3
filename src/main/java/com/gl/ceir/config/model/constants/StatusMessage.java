/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.model.constants;

/**
 *
 * @author maverick
 */
public enum StatusMessage {

    FOUND("Found"), NOT_FOUND("Not Found");

    private String name;

    StatusMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getMessage(String name) {
        for (StatusMessage names : StatusMessage.values()) {
            if (name.equals(names.getName())) {
                return names.toString();
            }
        }
        return null;
    }

}
