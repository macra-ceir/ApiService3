/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.service.userlogic;

import com.gl.ceir.config.model.app.UserVars;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author maverick
 */
@Service
public class UserDiffImpl {

    @Autowired
    UserFactory userFactory;

    private static final Logger logger = LogManager.getLogger(UserDiffImpl.class);

    public void getDetailsByUser(String user, String pass, int id) {
        var response =  userFactory.createUser().getUserDetailDao(user, pass, 1);
        logger.info("message" + response);
        UserVars userVars =  (UserVars) response;
        logger.info("userVars::" + userVars);

        if( userVars ==null || userVars.getId() == 0){
            logger.info("user value ::" + userVars.getUsername());
        }
    }
}
