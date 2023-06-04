package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.repo",
    includeFilters = { @Filter(type = FilterType.REGEX, pattern = ".*Repository")})
public class AppConfig {
    
}
