package com.SBS.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.SBS.bean.Result;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Result<Object>> exceptionHandler(Exception ex) {
		Result<Object> result = new Result<Object>();
		result.setError(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.setMsg(ex.getMessage());
		return new ResponseEntity<Result<Object>>(result, HttpStatus.OK);
	}
}
