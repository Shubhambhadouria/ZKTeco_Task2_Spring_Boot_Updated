package com.zkteco.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.zkteco.entity.MyErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException ue, WebRequest req){
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ue.getMessage());
		errorDetails.setDetail(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception ue, WebRequest req){
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ue.getMessage());
		errorDetails.setDetail(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
}
