package com.paypal.bfs.test.employeeserv.bean;

import java.util.StringJoiner;

public class ErrorInfo {

    private String errorCode;
    private String errorDesc;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ErrorInfo.class.getSimpleName() + "[", "]")
                .add("errorCode='" + errorCode + "'")
                .add("errorDesc='" + errorDesc + "'")
                .toString();
    }
}
