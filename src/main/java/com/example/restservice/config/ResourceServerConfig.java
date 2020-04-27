package com.example.restservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import java.util.Collections;

@Configuration
public class ResourceServerConfig {

    @Autowired
    private ResourceServerConfiguration resourceServerConfiguration;

    @Bean
    protected void publicResources() {
        resourceServerConfiguration.setConfigurers(Collections.singletonList(new ResourceServerConfigurerAdapter() {
            @Override
            public void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                        .antMatchers("/health").permitAll()
                        .antMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
                        .antMatchers(HttpMethod.GET, "/books").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated();
            }
        }));
    }

}
