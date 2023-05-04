package com.wbs.kos.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.wbs.kos.model.api.ApiError;
import com.wbs.kos.model.api.ResponseEntityBuilder;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// handleMethodArgumentTypeMismatch : triggers when a parameter's type does not match
	@ExceptionHandler({MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
                                                                      WebRequest request) {
        List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());
      
		ApiError err = new ApiError(LocalDateTime.now(),HttpStatus.BAD_REQUEST, "Mismatch Type" ,details);
		
		return ResponseEntityBuilder.build(err);
    }
	
	// handleConstraintViolationException : triggers when @Validated fails
	@ExceptionHandler({ConstraintViolationException.class})
	public ResponseEntity<?> handleConstraintViolationException(Exception ex, WebRequest request) {
		
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());
		
		ApiError err = new ApiError(LocalDateTime.now(),HttpStatus.BAD_REQUEST, "Constraint Violation" ,details);
		
		return ResponseEntityBuilder.build(err);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		
		ApiError err = new ApiError(LocalDateTime.now(),HttpStatus.BAD_REQUEST, "Error occurred" ,details);
		
		return ResponseEntityBuilder.build(err);
	
	}

    @ExceptionHandler({TokenExpiredException.class})
    public ResponseEntity<?> handleTokenExpiredException(TokenExpiredException tokenExpiredException) {
        return new ResponseEntity<>("Token has been expired", HttpStatus.FORBIDDEN);
    }
	
}