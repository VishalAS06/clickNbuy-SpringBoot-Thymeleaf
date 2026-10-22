package com.example.clickNbuy.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.resource.NoResourceFoundException;

@Controller
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoResourceFoundException.class)
	public String handle(NoResourceFoundException exception) {
		return "404.html";
	}

}
