package com.datasirpi.dschatbox.config;

import com.datasirpi.dschatbox.common.JwtInterceptor;
import com.datasirpi.dschatbox.dto.RequestMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebConfig implements WebMvcConfigurer {
    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor);
    }

    @Bean
    @RequestScope
    public RequestMeta getRequestMeta() {
        return new RequestMeta();
    }

    @Bean
    public JwtInterceptor jwtInterceptorBean() {
        return new JwtInterceptor(getRequestMeta());
    }
}
