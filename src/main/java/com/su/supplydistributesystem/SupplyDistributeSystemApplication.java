package com.su.supplydistributesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.su",
		"com.sug.core.platform.web",
		"com.sug.core.rest"
})
public class SupplyDistributeSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplyDistributeSystemApplication.class, args);
	}

}

