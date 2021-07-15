package com.paypal.bfs.test.employeeserv.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public enum EmployeeErrorCode {

    EMPLOYEE_ID_NOT_FOUND(4001, "Employee id not found in db", BAD_REQUEST),
    ADDRESS_ID_NOT_FOUND(4002, "Address id not found in db", BAD_REQUEST),
    REQUEST_BODY_INVALID(4003, "Request body is invalid", BAD_REQUEST),
    BAD_REQUEST_METHOD(4004, "Bad request method", BAD_REQUEST),
    BAD_CONTENT_TYPE_IN_REQUEST(4005, "Bad content type", BAD_REQUEST),
    REQUEST_PARAMETER_REQUIRED(4006, "Request parameters are required", BAD_REQUEST),
    REQUEST_BODY_REQUIRED(4007, "Request body is required", BAD_REQUEST),
    FIRST_NAME_REQUIRED(4008, "First name is required", BAD_REQUEST),
    LAST_NAME_REQUIRED(4009, "Last name is required", BAD_REQUEST),
    DATE_OF_BIRTH_REQUIRED(4010, "Date of birth is required", BAD_REQUEST),
    LINE_1_REQUIRED(4011, "Line 1 in address is required", BAD_REQUEST),
    CITY_REQUIRED(4012, "City in address is required", BAD_REQUEST),
    STATE_REQUIRED(4013, "State in address is required", BAD_REQUEST),
    COUNTRY_REQUIRED(4014, "Country in address is required", BAD_REQUEST),
    ZIP_CODE_REQUIRED(4015, "Zip code in address is required", BAD_REQUEST),
    INVALID_DATE(4016, "Date provided is invalid", BAD_REQUEST),
    ADDRESS_REQUIRED(4017, "Address is required", BAD_REQUEST),
    ;

    private HttpStatus httpStatus;
    private int code;
    private String desc;

    EmployeeErrorCode(int code, String desc, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return "EMP-" + this.code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getDesc() {
        return desc;
    }
}
