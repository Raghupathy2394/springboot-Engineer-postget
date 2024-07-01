package com.example.Engineer.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.Engineer.Dto.RequestDto;
import com.example.Engineer.common.JwtToken;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	
	@Autowired
	JwtToken jwtoken;
	
	@Autowired
	 RequestDto requestDto;
	


public JwtInterceptor(RequestDto requestDto) {
	this.requestDto = requestDto;
	}



@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {

 String auth=request.getHeader("authorization");
if(!(request.getRequestURI().contains("singup") || request.getRequestURI()
		.contains("login"))) {
			 Claims claims=jwtoken.verify(auth);
			 requestDto.setCity(claims.get("city").toString());
			 requestDto.setName(claims.get("name").toString());
			 requestDto.setRole(claims.get("role").toString());
		}
	return HandlerInterceptor.super.preHandle(request, response, handler);
}}
