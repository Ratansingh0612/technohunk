package com.synergisitic.it.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandelr {

	@ExceptionHandler(Exception.class)
	public String ahahhahah(Exception ex){
		 ex.printStackTrace();
		return "exception";
	}
}
