package com.daniel.api.handlers;

public class ExceptionResponse {

	private int status;
	private String message;
	
	public ExceptionResponse() {
		super();
	}
	
	public ExceptionResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
