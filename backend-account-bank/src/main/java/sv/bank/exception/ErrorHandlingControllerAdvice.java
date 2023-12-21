package sv.bank.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import sv.bank.dto.ResponseMessage;
import sv.bank.dto.ValidationErrorResponse;
import sv.bank.dto.Violation;
import sv.bank.util.AppConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
class ErrorHandlingControllerAdvice {
	
	private static final Logger LOG = LoggerFactory.getLogger(ErrorHandlingControllerAdvice.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		ValidationErrorResponse error = new ValidationErrorResponse(400L, 2L, "Validar campos de entrada");
		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			error.getViolations().add(new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		return error;
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationErrorResponse onMissingRequestHeaderException(MissingRequestHeaderException exception) {
		ValidationErrorResponse error = new ValidationErrorResponse(400L, 3L, "Validar datos Obligatorios del Header");
		error.getViolations().add(new Violation(exception.getHeaderName(), "No puede ser vacio o nulo"));

		return error;
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationErrorResponse onConstraintViolationException(ConstraintViolationException exception) {
		ValidationErrorResponse error = new ValidationErrorResponse(400L, 3L, "Validar datos Obligatorios del Header");
		for(ConstraintViolation<?> fieldError : exception.getConstraintViolations()) {
			error.getViolations().add(new Violation(fieldError.getPropertyPath().toString().replace("consultaSaldoTdc.", ""), fieldError.getMessage()));
		}
		return error;
	}

	@ExceptionHandler(BankAppException.class)
	@ResponseBody
	public ResponseEntity<Object> handleAllUncaughtException(BankAppException exception) {
		HttpStatus httpStatus = HttpStatus.valueOf(exception.getError().getCodeStatus().intValue());
		return new ResponseEntity<>(exception.getError(), httpStatus);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleAllUncaughtException(Exception exception, WebRequest request) {
		LOG.error(AppConstants.MSG_GENERIC_ERROR, exception);
		return new ResponseEntity<>(new ResponseMessage(500L, 99L, AppConstants.MSG_ERROR_INTERNAL), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleAllUncaughtException(RuntimeException exception, WebRequest request) {
		LOG.error(AppConstants.MSG_GENERIC_ERROR, exception);
		return new ResponseEntity<>(new ResponseMessage(500L, 99L, AppConstants.MSG_ERROR_INTERNAL), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
