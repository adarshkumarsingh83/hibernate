package com.espark.adarsh.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.espark.adarsh")
@PropertySource("classpath:/properties/application.properties")
public class ApplicationConfiguration {
}
