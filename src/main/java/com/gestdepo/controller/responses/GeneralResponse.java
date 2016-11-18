package com.gestdepo.controller.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GeneralResponse<T> extends ResponseEntity<T> {

	public GeneralResponse(HttpStatus statusCode) {
		super(statusCode);
		// TODO Auto-generated constructor stub
	}
	
}
