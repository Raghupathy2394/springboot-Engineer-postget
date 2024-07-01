package com.example.Engineer.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalException {
	
	@ExceptionHandler
	public ResponseEntity<ApiResponse> handlerAccessDeinedException(AccessDeniedException e){
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
		apiResponse.setData("Token invalid");
		apiResponse.setError(e.getMessage());
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
