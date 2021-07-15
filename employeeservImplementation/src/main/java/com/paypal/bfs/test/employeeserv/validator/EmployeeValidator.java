package com.paypal.bfs.test.employeeserv.validator;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exception.EmployeeErrorCode;
import com.paypal.bfs.test.employeeserv.util.ValidationUtil;

public class EmployeeValidator {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static void validate(Employee employee) {

        ValidationUtil.isNotNull(employee, EmployeeErrorCode.REQUEST_BODY_REQUIRED);
        ValidationUtil.isNotBlank(employee.getFirstName(), EmployeeErrorCode.FIRST_NAME_REQUIRED);
        ValidationUtil.isNotBlank(employee.getLastName(), EmployeeErrorCode.LAST_NAME_REQUIRED);
        ValidationUtil.isNotBlank(employee.getDateOfBirth(), EmployeeErrorCode.DATE_OF_BIRTH_REQUIRED);
        ValidationUtil.isValidDate(employee.getDateOfBirth(), DATE_FORMAT, EmployeeErrorCode.INVALID_DATE);
        ValidationUtil.isNotNull(employee.getAddress(), EmployeeErrorCode.ADDRESS_REQUIRED);

        Address address = employee.getAddress();
        ValidationUtil.isNotBlank(address.getLine1(), EmployeeErrorCode.LINE_1_REQUIRED);
        ValidationUtil.isNotBlank(address.getCity(), EmployeeErrorCode.CITY_REQUIRED);
        ValidationUtil.isNotBlank(address.getCountry(), EmployeeErrorCode.COUNTRY_REQUIRED);
        ValidationUtil.isNotBlank(address.getState(), EmployeeErrorCode.STATE_REQUIRED);
        ValidationUtil.isNotBlank(address.getZipCode(), EmployeeErrorCode.ZIP_CODE_REQUIRED);
    }
}
