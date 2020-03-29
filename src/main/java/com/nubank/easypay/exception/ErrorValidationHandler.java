package com.nubank.easypay.exception;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
* This class treated the code error to response an understandable message to this error. 
*
* @author Wanessa Nascimento
*/

@RestControllerAdvice
public class ErrorValidationHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorValidationHandler.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public String exceptionDefault(Exception exception) {
		LOGGER.info(MessageFormat.format("System error. {0}", exception.getMessage()));
		return exception.getMessage();
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ExceptionFormDto> handle(MethodArgumentNotValidException exception) {
		List<ExceptionFormDto> dto = getErrorDetail(exception);
		LOGGER.info(MessageFormat.format("Method argument error. {0}", exception.getMessage()));
		return dto;
	}

	private List<ExceptionFormDto> getErrorDetail(MethodArgumentNotValidException exception) {
		List<ExceptionFormDto> dto = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		for(FieldError fildError : fieldErrors) {
			String mensagem = messageSource.getMessage(fildError, LocaleContextHolder.getLocale());
			ExceptionFormDto erro = new ExceptionFormDto(fildError.getField(), mensagem);
			dto.add(erro);
		}
		return dto;
	}
}
