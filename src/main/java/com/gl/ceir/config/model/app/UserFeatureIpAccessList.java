/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.model.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserFeatureIpAccessList {

    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int featureIpListId;

    private int userId;

    private String ipAddress;

    @Override
    public String toString() {
        return "UserFeatureIpAccessList{" + "id=" + id + ", featureIpListId=" + featureIpListId + ", userId=" + userId + ", ipAddress=" + ipAddress + '}';
    }

}
