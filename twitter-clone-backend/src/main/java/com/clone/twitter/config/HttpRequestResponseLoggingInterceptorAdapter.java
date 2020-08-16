package com.clone.twitter.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class HttpRequestResponseLoggingInterceptorAdapter extends HandlerInterceptorAdapter {
	
	@Autowired
	private LoggingUtils loggingutils;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		loggingutils.preHandle(request, response);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) {
		try {
			loggingutils.postHandle(request, response);
		} catch(Exception e) {
			System.out.println("Exception while logging outgoing response");
		}
	}
}
