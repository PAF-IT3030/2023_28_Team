package com.paf.favorfeed.exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private String message;
	private String details;
	private LocalDateTime timestamp;
	
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(String message, String details, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}

	
	
	
}
