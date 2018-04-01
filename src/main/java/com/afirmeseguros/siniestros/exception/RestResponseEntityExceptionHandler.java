package com.afirmeseguros.siniestros.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
 

	@ExceptionHandler(GenericException.class)
	public void handleGenericException(HttpServletResponse response, Exception e) throws IOException{
		response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public void handleResourceNotFoundException(HttpServletResponse response, Exception e) throws IOException{
		response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
	}

}