package com.paypal.bfs.test.employeeserv.exception;

public class EmployeeException extends RuntimeException {

    private EmployeeErrorCode employeeErrorCode;

    public EmployeeException(EmployeeErrorCode employeeErrorCode) {
        super(employeeErrorCode.getCode() + " : " + employeeErrorCode.getDesc());
        this.employeeErrorCode = employeeErrorCode;
    }

    public EmployeeErrorCode getEmployeeErrorCode() {
        return employeeErrorCode;
    }
}
