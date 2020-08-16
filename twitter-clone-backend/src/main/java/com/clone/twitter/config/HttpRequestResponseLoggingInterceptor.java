package com.clone.twitter.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class HttpRequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {
	
	@Autowired
	private LoggingUtils loggingUtils;

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		loggingUtils.traceRequest(request, body);
		ClientHttpResponse response = execution.execute(request, body);
		loggingUtils.traceResponse(request, body);
		return response;
		
	}
}
