package com.sprint.eai.designpattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.sprint.eai.designpattern.dao.ConnectionFactory;

/**
 * Main class
 * 
 * @author pborsoni
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ConnectionFactory.populateTestData();
	}

}
