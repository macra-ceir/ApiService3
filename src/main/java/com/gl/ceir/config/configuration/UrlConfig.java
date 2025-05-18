package com.gl.ceir.config.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class UrlConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Design/**").addResourceLocations("file:/home/ubuntu/apache-tomcat-9.0.4/webapps/Design/").setCachePeriod(0)
                .resourceChain(true).addResolver(new PathResourceResolver());
    }

}
