package com.example.ApplaudoTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.applaudo",})
@PropertySource("application.properties")
@EntityScan(basePackages = {"com.applaudo.entity"})
@EnableJpaRepositories(basePackages="com.applaudo.repository") 
public class ApplaudoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplaudoTestApplication.class, args);
	}

}
