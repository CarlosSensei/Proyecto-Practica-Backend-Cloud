package com.ccsw.tutorialloans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TutorialloansApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialloansApplication.class, args);
	}

}
