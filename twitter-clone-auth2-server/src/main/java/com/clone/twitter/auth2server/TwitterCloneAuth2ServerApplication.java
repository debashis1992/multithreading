package com.clone.twitter.auth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TwitterCloneAuth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterCloneAuth2ServerApplication.class, args);
	}
}
