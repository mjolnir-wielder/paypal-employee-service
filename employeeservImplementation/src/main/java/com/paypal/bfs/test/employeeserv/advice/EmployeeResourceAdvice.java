package com.paypal.bfs.test.employeeserv.advice;

import com.paypal.bfs.test.employeeserv.bean.ErrorInfo;
import com.paypal.bfs.test.employeeserv.exception.EmployeeErrorCode;
import com.paypal.bfs.test.employeeserv.exception.EmployeeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeResourceAdvice {

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ErrorInfo> handleException(EmployeeException employeeException) {
        EmployeeErrorCode employeeErrorCode = employeeException.getEmployeeErrorCode();
        return new ResponseEntity<>(getErrorInfo(employeeErrorCode), employeeErrorCode.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> handleException(Exception exception) {
        return new ResponseEntity<>(getErrorInfo(exception), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorInfo> handleException(HttpMessageNotReadableException exception) {
        EmployeeErrorCode employeeErrorCode = EmployeeErrorCode.REQUEST_BODY_INVALID;
        return new ResponseEntity<>(getErrorInfo(employeeErrorCode), employeeErrorCode.getHttpStatus());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorInfo> handleException(MissingServletRequestParameterException exception) {
        EmployeeErrorCode employeeErrorCode = EmployeeErrorCode.REQUEST_PARAMETER_REQUIRED;
        return new ResponseEntity<>(getErrorInfo(employeeErrorCode), employeeErrorCode.getHttpStatus());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorInfo> handleException(HttpMediaTypeNotSupportedException exception) {
        EmployeeErrorCode employeeErrorCode = EmployeeErrorCode.BAD_CONTENT_TYPE_IN_REQUEST;
        return new ResponseEntity<>(getErrorInfo(employeeErrorCode), employeeErrorCode.getHttpStatus());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorInfo> handleException(HttpRequestMethodNotSupportedException exception) {
        EmployeeErrorCode employeeErrorCode = EmployeeErrorCode.BAD_REQUEST_METHOD;
        return new ResponseEntity<>(getErrorInfo(employeeErrorCode), employeeErrorCode.getHttpStatus());
    }

    private ErrorInfo getErrorInfo(Exception exception) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode(exception.getMessage());
        errorInfo.setErrorDesc(exception.getLocalizedMessage());
        return errorInfo;
    }

    private ErrorInfo getErrorInfo(EmployeeErrorCode employeeErrorCode) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode(employeeErrorCode.getCode());
        errorInfo.setErrorDesc(employeeErrorCode.getDesc());
        return errorInfo;
    }
}
