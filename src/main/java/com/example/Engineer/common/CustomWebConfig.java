package com.example.Engineer.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.Engineer.Dto.RequestDto;
import com.example.Engineer.jwt.JwtInterceptor;

@Configuration
public class CustomWebConfig implements WebMvcConfigurer{
	
	@Autowired
	JwtInterceptor jwtInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	
		registry.addInterceptor(jwtInterceptor);
	}

	@Bean
	@RequestScope
	public RequestDto getRequestDto() {
		return new RequestDto();
	}
	@Bean
	public JwtInterceptor interceptor() {
		return new JwtInterceptor(getRequestDto());
	}
}
