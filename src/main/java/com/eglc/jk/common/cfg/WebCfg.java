package com.eglc.jk.common.cfg;

import com.eglc.jk.common.prop.JkProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCfg implements WebMvcConfigurer {
    @Autowired
    private JkProperties properties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(properties.getCfg().getCorsOrigins())
                .allowCredentials(true)
                .allowedMethods("GET","POST");
    }
}
