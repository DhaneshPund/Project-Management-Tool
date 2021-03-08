package com.app.exc_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_exceptions.UserHandlingException;
import com.app.dto.ErrorResponse;

@ControllerAdvice // mandatory class level annotation to tell SC : that whatever follows will
					// handle ANY exc
					// raised in any Controller/RestContoller
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UserHandlingException.class)
	public ResponseEntity<?> handleCustomerHandlingException(UserHandlingException e) {
		System.out.println("in cust hand exc " + e);
		return new ResponseEntity<>(new ErrorResponse("User Auth Failed .....", e.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}

//	@ExceptionHandler(AccountHandlingException.class)
//	public ResponseEntity<?> handleAccountHandlingException(AccountHandlingException e) {
//		System.out.println("in acct handling exc " + e);
//		return new ResponseEntity<>(new ErrorResponse("Fetching a/c summary failed ", e.getMessage()),
//				HttpStatus.NOT_FOUND);
//	}

}
