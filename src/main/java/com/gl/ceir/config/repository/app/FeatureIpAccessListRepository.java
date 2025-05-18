/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.FeatureIpAccessList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author maverick
 */
public interface FeatureIpAccessListRepository extends JpaRepository< FeatureIpAccessList, Integer> {

    //  public FeatureIpAccessList getByUsernameAndPasswordAndParentId(String userName, String password, String parentId);
    public FeatureIpAccessList getByFeatureId(String checkimeiFeatureType);
}
