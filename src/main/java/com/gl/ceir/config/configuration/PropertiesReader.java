package com.gl.ceir.config.configuration;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
//@RefreshScope
// @EnableScheduling

@PropertySources({
    @PropertySource(value = {"file:../../../../../../resources/application.properties"}, ignoreResourceNotFound = true),
    @PropertySource(value = {"file:configuration.properties"}, ignoreResourceNotFound = true)
})


public class PropertiesReader {

    @Value("${spring.jpa.properties.hibernate.dialect}")
    public String dialect;

    @Value("${date.view.format}")
    public String dateViewFormat;

    @Value("${default-no-of-regularized-devices}")
    public Long defaultNoOfRegularizedDevices1;

    @Value("${local-ip}")
    public String localIp1;

    @Value("#{'${Top5Brands}'.split(',')}")
    public List<String> top5Brands;

    public List<String> getTop5Brands() {
        return top5Brands;
    }

}
