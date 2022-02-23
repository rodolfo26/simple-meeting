package com.googlemeetclone.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.googlemeetclone")
@ComponentScan({"com.googlemeetclone"})
@EntityScan("com.googlemeetclone.model")
@EnableJpaRepositories("com.googlemeetclone.repository")
public class GooglemeetBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GooglemeetBackendApplication.class, args);
	}

}
