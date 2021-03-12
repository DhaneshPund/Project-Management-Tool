package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class ProjectHandlingException extends RuntimeException {
	public ProjectHandlingException(String mesg) {
		super(mesg);
	}
}
