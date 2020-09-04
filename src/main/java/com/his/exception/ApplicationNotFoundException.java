package com.his.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApplicationNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1279600985949158282L;

	public ApplicationNotFoundException(String message) {
		super(message);
	}
}
