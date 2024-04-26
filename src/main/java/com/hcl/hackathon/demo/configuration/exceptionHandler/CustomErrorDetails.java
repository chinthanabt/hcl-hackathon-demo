package com.hcl.hackathon.demo.configuration.exceptionHandler;

import lombok.Data;

@Data
public class CustomErrorDetails {
    private String message;
    private String errorCode;

    public static CustomErrorDetails of(String errorCode, String message) {
        CustomErrorDetails customErrorDetails = new CustomErrorDetails();
        customErrorDetails.setErrorCode(errorCode);
        customErrorDetails.setMessage(message);
        return customErrorDetails;
    }
}
