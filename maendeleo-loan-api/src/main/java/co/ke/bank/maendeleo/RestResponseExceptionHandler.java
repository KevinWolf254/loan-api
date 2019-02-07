package co.ke.bank.maendeleo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.ke.bank.maendeleo.pojos.ResponseBindError;
import co.ke.bank.maendeleo.pojos.ResponseError;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
	private final static Logger LOG = LoggerFactory.getLogger(RestResponseExceptionHandler.class);

	@Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
		final List<FieldError> bindErrors = ex.getBindingResult().getFieldErrors();
        final List<String> errors = new ArrayList<>();
        for (FieldError e : bindErrors){
        	errors.add(e.getField() + ": " + e.getDefaultMessage());
        }        
		final ResponseBindError errorDetails = new ResponseBindError(status.value(), "Validation Errors", errors);
		
		LOG.error("MethodArgumentNotValidException: "+errorDetails);
	    return new ResponseEntity<>(errorDetails, status);
	  }
	
	@ExceptionHandler(value = {Exception.class})
	protected ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
		final HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;
		final int status = internalServerError.value();
		final ResponseError response = new ResponseError(status, ex.getLocalizedMessage());
		
		LOG.error("Exception: "+response);
		return new ResponseEntity<>(response, new HttpHeaders(), internalServerError);
	}
}
