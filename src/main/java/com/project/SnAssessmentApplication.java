package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.project.*"})
@PropertySource("classpath:application.properties")
public class SnAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnAssessmentApplication.class, args);
	}
}
