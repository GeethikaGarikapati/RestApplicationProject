package com.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8129551308576996988L;

	public BadRequestException(String message) {
		super(message);
	}
}
