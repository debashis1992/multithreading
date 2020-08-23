package com.clone.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableMongoAuditing
public class TwitterCloneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterCloneBackendApplication.class, args);
	}

}
