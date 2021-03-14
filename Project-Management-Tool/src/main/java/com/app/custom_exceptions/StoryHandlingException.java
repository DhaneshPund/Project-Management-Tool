package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class StoryHandlingException extends RuntimeException {
	public StoryHandlingException(String mesg) {
		super(mesg);
	}

}
