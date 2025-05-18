///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.gl.ceir.config;
//
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
//import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
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
//        basePackages = {"com.gl.ceir.config.repository.config"},  // 
//        entityManagerFactoryRef = "configEntityManagerFactory",
//        transactionManagerRef = "configTransactionManager")
//
//public class ConfigDbConfig {
//
//    @Bean(name = "configEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean configEntityManagerFactory(
//            @Qualifier("configDataSource") DataSource dataSource,
//            EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(dataSource)
//                .packages("com.gl.ceir.config.model.config")  //
//                .persistenceUnit("config")    
//                .properties(jpaProperties())     //
//                .build();
//    }
//
//    @Bean(name = "configDataSource")
//    @ConfigurationProperties(prefix = "config.datasource")               //
//    public DataSource configDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "configTransactionManager")
//    public PlatformTransactionManager configTransactionManager(
//            @Qualifier("configEntityManagerFactory") LocalContainerEntityManagerFactoryBean configEntityManagerFactory) {
//        return new JpaTransactionManager(Objects.requireNonNull(configEntityManagerFactory.getObject()));
//    }
//    
//    
//    
//       protected Map<String, Object> jpaProperties() {
//    Map<String, Object> props = new HashMap<>();
//    props.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
//    props.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
//    return props;
//}
//
//}
//
//
//
