package com.clone.twitter.auth2server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Configuration
@ConfigurationProperties(prefix = "user.oauth")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OAuth2ConfigProperties {
	String clientId;
	String clientSecret;
	String redirectUri;
	String username;
	String password;
	
}
