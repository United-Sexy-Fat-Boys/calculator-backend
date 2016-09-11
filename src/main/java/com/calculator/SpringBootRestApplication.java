package com.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Entry point
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableAsync
@Configuration
public class SpringBootRestApplication extends SpringBootServletInitializer {
    private static Logger springLogger = LoggerFactory.getLogger(SpringBootRestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApplication.class, args);
        springLogger.info("Successfully started application: " + SpringBootRestApplication.class.getSimpleName());
    }
}