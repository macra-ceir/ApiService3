///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.gl.ceir.config;
//
//import java.util.Objects;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = {"com.gl.ceir.config.repository.report"},  // 
//        entityManagerFactoryRef = "reportEntityManagerFactory",
//        transactionManagerRef = "reportTransactionManager")
//
//public class ReportDbConfig {
//
//    @Bean(name = "reportEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean reportEntityManagerFactory(
//            @Qualifier("reportDataSource") DataSource dataSource,
//            EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(dataSource)
//                .packages("com.gl.ceir.config.model.report")  //
//                .persistenceUnit("report")                   //
//                .build();
//    }
//
//    @Bean(name = "reportDataSource")
//    @ConfigurationProperties(prefix = "report.datasource")               //
//    public DataSource reportDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "reportTransactionManager")
//    public PlatformTransactionManager reportTransactionManager(
//            @Qualifier("reportEntityManagerFactory") LocalContainerEntityManagerFactoryBean reportEntityManagerFactory) {
//        return new JpaTransactionManager(Objects.requireNonNull(reportEntityManagerFactory.getObject()));
//    }
//
//}
//
//
//
