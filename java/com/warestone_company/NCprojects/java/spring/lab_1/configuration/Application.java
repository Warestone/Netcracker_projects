package com.warestone_company.NCprojects.java.spring.lab_1.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
import java.util.Properties;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.parse("2KB"));
        factory.setMaxRequestSize(DataSize.parse("2KB"));
        return factory.createMultipartConfig();
    }
}