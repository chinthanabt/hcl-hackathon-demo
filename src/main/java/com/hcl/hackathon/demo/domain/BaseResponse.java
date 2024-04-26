package com.hcl.hackathon.demo.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class BaseResponse {
    private String statusCode;

    private String statusMessage;

    private Object data;

    public static BaseResponse of(String statusCode, String statusMessage, Object data) {
        BaseResponse response = new BaseResponse();
        response.setData(data);
        response.setStatusCode(statusCode);
        response.setStatusMessage(statusMessage);
        return response;
    }
}
