///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.gl.ceir.config.configuration;
//
///**
// *
// * @author maverick
// */
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.orm.jpa.EntityManagerFactoryInfo;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class ConnectionConfiguration {
//
//    @PersistenceContext
//    private EntityManager em;
//    private static final Logger logger = LogManager.getLogger(ConnectionConfiguration.class);
//
//    public Connection getConnection() {
//        try {
//            EntityManagerFactoryInfo info = (EntityManagerFactoryInfo) em.getEntityManagerFactory();
//            return info.getDataSource().getConnection();
//        } catch (SQLException e) {
//            logger.error("Error " + e + " :: " + e.getLocalizedMessage());
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//}
//
//
//
//
