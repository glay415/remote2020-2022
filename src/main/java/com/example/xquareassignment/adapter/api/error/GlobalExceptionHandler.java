package com.example.xquareassignment.adapter.api.error;

import com.example.xquareassignment.global.error.CustomException;
import com.example.xquareassignment.global.error.ErrorCode;
import com.example.xquareassignment.global.error.ErrorResponse;
import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> handleGlobal(CustomException e) {
		ErrorCode errorCode = e.getErrorCode();

		return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(), errorCode.getMessage()),
			HttpStatus.valueOf(errorCode.getStatus()));
	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<?> bindException(BindException e) {
		Map<String, String> errorMap = new HashMap<>();

		for (FieldError error : e.getFieldErrors()) {
			errorMap.put(error.getField(), error.getDefaultMessage());
		}
		return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e) {
		Map<String, String> errorMap = new HashMap<>();

		int i = 0;

		for (ConstraintViolation<?> error : e.getConstraintViolations()) {
			errorMap.put("error" + i, error.getMessageTemplate());
			i++;
		}

		return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
	}
}
