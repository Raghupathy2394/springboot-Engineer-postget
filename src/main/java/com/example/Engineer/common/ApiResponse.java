package com.example.Engineer.common;

import org.springframework.http.HttpStatusCode;

import lombok.Data;

@Data
public class ApiResponse {
	
	private Integer status;
	
	private Object data;
	
	private Object error;

}
