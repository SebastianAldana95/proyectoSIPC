package edu.udec.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorWrapper> manejadorException(Exception ex,
			WebRequest request){
		ErrorWrapper er = new ErrorWrapper(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage(), ex.getStackTrace().toString(), request.getDescription(false));
		return new ResponseEntity<ErrorWrapper>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<ErrorWrapper> manejadorValueNoPresentException(NoSuchElementException ex,
			WebRequest request){
		ErrorWrapper error = new ErrorWrapper(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), ex.getStackTrace().toString(), request.getDescription(false));
		return new ResponseEntity<ErrorWrapper>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ErrorWrapper> manejadorNotFoundException(NotFoundException ex,
			WebRequest request){
		ErrorWrapper error = new ErrorWrapper(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), ex.getMessage().toString(), ex.getStackTrace().toString(), request.getDescription(false));
		return new ResponseEntity<ErrorWrapper>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<ErrorWrapper> manejadorNullPointerException(NullPointerException ex,
			WebRequest request){
		ErrorWrapper er = new ErrorWrapper(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), ex.getStackTrace().toString(), request.getDescription(false));
		return new ResponseEntity<ErrorWrapper>(er, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ArgumentRequiredException.class)
	public final ResponseEntity<ErrorWrapper> manejadorArgumentRequiredException(ArgumentRequiredException ex,
			WebRequest request){
		ErrorWrapper er = new ErrorWrapper(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), ex.getStackTrace().toString(), request.getDescription(false));
		return new ResponseEntity<ErrorWrapper>(er, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
	public final ResponseEntity<ErrorWrapper> manejadorConstraintViolationException(org.hibernate.exception.ConstraintViolationException ex,
			WebRequest request){
		ErrorWrapper er = new ErrorWrapper(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), ex.getStackTrace().toString(), request.getDescription(false));
		return new ResponseEntity<ErrorWrapper>(er, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorWrapper error = new ErrorWrapper(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), ex.getStackTrace().toString(), request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorWrapper error = new ErrorWrapper(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), ex.getStackTrace().toString(), request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorWrapper error = new ErrorWrapper(HttpStatus.METHOD_NOT_ALLOWED.value(), HttpStatus.METHOD_NOT_ALLOWED.toString(), ex.getMessage(), ex.getStackTrace().toString(), request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorWrapper error = new ErrorWrapper(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), ex.getStackTrace().toString(), request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

	
	
}
