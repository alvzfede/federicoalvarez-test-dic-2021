package com.example.ItemApiApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.item",})
@PropertySource("application.properties")
@EntityScan(basePackages = {"com.item.entity"})
@EnableJpaRepositories(basePackages="com.item.repository") 
public class ItemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemApiApplication.class, args);
	}

}
