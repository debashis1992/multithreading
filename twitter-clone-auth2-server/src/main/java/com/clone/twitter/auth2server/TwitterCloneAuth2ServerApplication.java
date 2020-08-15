package com.clone.twitter.auth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
public class TwitterCloneAuth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterCloneAuth2ServerApplication.class, args);
	}

}
