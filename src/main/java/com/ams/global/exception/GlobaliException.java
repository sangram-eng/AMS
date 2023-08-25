package com.ams.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.ams.business.exception.BusinessExeption;
import com.ams.business.exception.ControllerException;


@ControllerAdvice
public class GlobaliException {
	
		@ExceptionHandler(BusinessExeption.class)
		ResponseEntity<?> handleBussinessException(BusinessExeption e){
			return new ResponseEntity<>(new ControllerException(e.getErrorCode(),e.getErrorMessage()), HttpStatus.BAD_REQUEST);
		
	}

}
