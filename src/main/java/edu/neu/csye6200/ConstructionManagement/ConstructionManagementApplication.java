package edu.neu.csye6200.ConstructionManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConstructionManagementApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ConstructionManagementApplication.class);
		application.setLazyInitialization(true);
		application.run(args);
	}

}
