package com.clone.twitter.config;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

@Component
public class LoggingUtils {
	
	public static final Logger logger = Logger.getLogger(LoggingUtils.class);
	
	public void traceRequest(HttpRequest httpRequest, byte[] body) throws IOException {
		String httpMethod = httpRequest.getMethodValue();
		String url = httpRequest.getURI().toString();
		String httpHeaders = httpRequest.getHeaders().toSingleValueMap().toString();
		String requestBody = body.toString();
		
		trace(httpMethod, url, httpHeaders, requestBody, "INCOMING");
	}
	
	public void traceResponse(HttpRequest httpRequest, byte[] body) throws IOException {
		String httpMethod = httpRequest.getMethodValue();
		String url = httpRequest.getURI().toString();
		String httpHeaders = httpRequest.getHeaders().toSingleValueMap().toString();
		String requestBody = body.toString();
		
		trace(httpMethod, url, httpHeaders, requestBody, "OUTGOING");
	}

	public void preHandle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String httpMethod = request.getMethod();
		String url = request.getRequestURL().toString();
		
		Enumeration<String> headersEnum = request.getHeaderNames();
		StringBuilder sbHeaders = new StringBuilder();
		while(headersEnum.hasMoreElements()) {
			String headerKey = headersEnum.nextElement();
			String headerVal = request.getHeader(headerKey);
			sbHeaders.append(headerKey).append(" : ").append(headerVal).append(" ");
		}
		String requestBody = null;
		if("POST".equals(httpMethod) || "PUT".equals(httpMethod)) {
			requestBody = request.getInputStream().readAllBytes().toString();
		}
		
		trace(httpMethod, url, sbHeaders.toString(), requestBody, "INCOMING");
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
//		byte[] body = responseWrapper.getContentAsByteArray();
//		String responseBody = new String(body);
//		responseWrapper.copyBodyToResponse();
//		logger.info("Outgoing response : "+responseBody);
	}
	
	private void trace(String httpMethod, String url, String httpHeaders, String requestBody, String requestType) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("[HTTP METHOD]").append("[").append(httpMethod).append("]").append("\n");
		sb.append("[HTTP URL]").append("[").append(url).append("]").append("\n");
		sb.append("[HTTP HEADERS]").append("[").append(httpHeaders==null ? "" : httpHeaders).append("]").append("\n");
		sb.append("[REQUEST BODY]").append("[").append(requestBody==null? "" : requestBody).append("]");
		if(requestType.equals("INCOMING"))
			logger.info("Incoming request: "+sb.toString());
	}
}
