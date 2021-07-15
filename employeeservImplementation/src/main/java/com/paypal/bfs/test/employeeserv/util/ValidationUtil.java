package com.paypal.bfs.test.employeeserv.util;

import com.paypal.bfs.test.employeeserv.exception.EmployeeErrorCode;
import com.paypal.bfs.test.employeeserv.exception.EmployeeException;
import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;

public class ValidationUtil {

    public static void isNotBlank(String str, EmployeeErrorCode code) {
        if (StringUtils.isBlank(str)) {
            throw new EmployeeException(code);
        }
    }

    public static void isNotNull(Object obj, EmployeeErrorCode code) {
        if (Objects.isNull(obj)) {
            throw new EmployeeException(code);
        }
    }

    public static void isValidDate(String date, String format, EmployeeErrorCode code) {
        DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        try {
            dateFormat.parse(date);
        } catch (ParseException e) {
            throw new EmployeeException(code);
        }
    }
}
