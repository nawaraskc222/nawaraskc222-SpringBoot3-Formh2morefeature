package com.SpringBootDemo5.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;






@SpringBootApplication
public class SpringBootDemo5Application extends SpringBootServletInitializer{

	  @Override
	    protected SpringApplicationBuilder configure(
	      SpringApplicationBuilder builder) {
	        return builder.sources(SpringBootDemo5Application.class);
	    }
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo5Application.class, args);
	}

}
