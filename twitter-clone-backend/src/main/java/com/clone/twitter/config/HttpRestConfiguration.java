package com.clone.twitter.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpRestConfiguration {
	
	@Autowired
	private HttpRequestResponseLoggingInterceptor httpReqResInterceptor;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setInterceptors(Collections.singletonList(httpReqResInterceptor));
	    return restTemplate;
	}
	
}
