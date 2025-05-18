package com.gl.ceir;


import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaAuditing

// @EnableCaching
@EntityScan({"com.gl.ceir.config.model" , "com.gl"})

@ComponentScan({"com.gl.ceir.config" , "com.gl" ,"com.gl.custom"})

@EnableEncryptableProperties


public class ConfigApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConfigApplication.class, args);
    }
}
