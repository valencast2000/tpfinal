package com.coop.tpfinal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class BackendApplication extends SpringBootServletInitializer implements CommandLineRunner{

	public static void main(String[] args) {
		
		SpringApplication.run(BackendApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}
