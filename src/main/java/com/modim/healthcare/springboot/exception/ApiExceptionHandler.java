package com.modim.healthcare.springboot.exception;

import com.modim.healthcare.springboot.utils.StaticStrings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler
{

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request)
    {
        return buildResponseEntity(new ApiException(HttpStatus.BAD_REQUEST, StaticStrings.FAIL, StaticStrings.FAIL_KR, ex));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    protected ResponseEntity<Object> handleUserAlreadyExistsException(Exception exception, WebRequest request)
    {
        return buildResponseEntity(new ApiException(HttpStatus.BAD_REQUEST, StaticStrings.FAIL, StaticStrings.FAIL_KR, exception));
    }

    @ExceptionHandler(TransactionSystemException.class)
    protected ResponseEntity<Object> handleTransactionSystemException(TransactionSystemException exception, WebRequest request)
    {
        logger.info(exception.getClass().getName());
        final List<String> errors = new ArrayList<String>();
        Throwable cause = ((TransactionSystemException) exception).getRootCause();
        if(cause instanceof ConstraintViolationException){
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) cause;
            for (final ConstraintViolation<?> violation : constraintViolationException.getConstraintViolations()) {
                errors.add(violation.getPropertyPath() + ": " + violation.getMessage());
            }
        }
        final ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, StaticStrings.FAIL, errors.get(0), exception);
        return buildResponseEntity(apiException);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiException apiError) {
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }
}
