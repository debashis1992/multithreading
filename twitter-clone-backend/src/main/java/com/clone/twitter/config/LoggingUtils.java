package com.clone.twitter.config;

import java.io.IOException;

import org.jboss.logging.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

@Component
public class LoggingUtils {

	public static final Logger logger = Logger.getLogger(LoggingUtils.class);

	public void traceRequest(HttpRequest httpRequest, byte[] body) throws IOException {
		String httpMethod = httpRequest.getMethodValue();
		String url = httpRequest.getURI().toString();
		String httpHeaders = httpRequest.getHeaders().toSingleValueMap().toString();
		String requestBody = body.toString();

		trace(httpMethod, url, httpHeaders, requestBody, "OUTGOING");
	}

	public void traceResponse(HttpRequest httpRequest, byte[] body) throws IOException {
		String httpMethod = httpRequest.getMethodValue();
		String url = httpRequest.getURI().toString();
		String httpHeaders = httpRequest.getHeaders().toSingleValueMap().toString();
		String requestBody = body.toString();

		trace(httpMethod, url, httpHeaders, requestBody, "INCOMING RESPONSE");
	}

	private void trace(String httpMethod, String url, String httpHeaders, String requestBody, String requestType) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("[HTTP METHOD]").append("[").append(httpMethod).append("]").append("\n");
		sb.append("[HTTP URL]").append("[").append(url).append("]").append("\n");
		sb.append("[HTTP HEADERS]").append("[").append(httpHeaders == null ? "" : httpHeaders).append("]").append("\n");
		sb.append("[REQUEST BODY]").append("[").append(requestBody == null ? "" : requestBody).append("]");
		if (requestType.equals("INCOMING"))
			logger.info("Incoming request: " + sb.toString());
		else if (requestType.equals("OUTGOING"))
			logger.info("Outgoing Request: " + sb.toString());
		else if (requestType.equals("INCOMING RESPONSE"))
			logger.info("Incoming response : " + requestBody);
	}
}
