package com.SBS.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SBS.bean.Result;

@RestController
@RequestMapping("/api")
public class WebExceptionTest {

	@GetMapping("/ExceptionTest")
	public Result<Object> returnException(@RequestParam int ex) throws Exception {
		if(ex != 1)
			throw new RuntimeException("this is exception2 message");
		throw new Exception("this is exception1 message");
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Result<Object>> exceptionHandler(Exception ex) {
		Result<Object> result = new Result<Object>();
		result.setError(-114)
				.setMsg(ex.getMessage());
		return new ResponseEntity<Result<Object>>(result, HttpStatus.OK);
	}
}
