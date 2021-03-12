package com.app.exc_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_exceptions.ProjectHandlingException;
import com.app.custom_exceptions.UserHandlingException;
import com.app.dto.ErrorResponse;

@ControllerAdvice // mandatory class level annotation to tell SC : that whatever follows will
					// handle ANY exc
					// raised in any Controller/RestContoller
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UserHandlingException.class)
	public ResponseEntity<?> handleCustomerHandlingException(UserHandlingException e) {
		System.out.println("in cust hand exc " + e);
		return new ResponseEntity<>(new ErrorResponse("User Exception .....", e.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(ProjectHandlingException.class)
	public ResponseEntity<?> handleProjectHandlingException(ProjectHandlingException e) {
		System.out.println("in cust hand exc " + e);
		return new ResponseEntity<>(new ErrorResponse("Project Exception .....", e.getMessage()),
				HttpStatus.BAD_REQUEST);
	}
}
