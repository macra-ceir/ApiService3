package com.gl.ceir.config.service.userlogic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserFactory {
    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    UserDetailDao userDetailDao;

    @Autowired
    UsersDetailDao usersDetailDao;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    public String dialect;

    public UserInterface createUser() {
        logger.info("Getting object for " + dialect);
        if (dialect.toLowerCase().contains("mysql")) return userDetailDao;
        else return usersDetailDao;

    }
}


//        return switch (channel) {
//            case "mysql" -> userDetailDao;
//            case "oracle" -> usersDetailDao;
//            default -> throw new IllegalArgumentException("Unknown channel " + channel);
//        };