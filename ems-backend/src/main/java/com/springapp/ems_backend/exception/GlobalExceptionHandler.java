package com.springapp.ems_backend.exception;

import java.sql.Date;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(DataIntegrityViolationException.class)

//	public ResponseEntity<ErrorDetails> handleDataIntegrityException(DataIntegrityViolationException exception, WebRequest webRequest) {
//
//	ErrorDetails errorDetails = new ErrorDetails(
//
//	new Date(),
//
//	"Email already exists! Please use a unique email address.",
//
//	webRequest.getDescription(false)
//
//	);
//
//	return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
//
//	}
}
