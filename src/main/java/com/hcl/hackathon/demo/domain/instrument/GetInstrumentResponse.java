package com.hcl.hackathon.demo.domain.instrument;

import com.hcl.hackathon.demo.domain.BaseResponse;
import com.hcl.hackathon.demo.domain.user.GetUsersResponse;

public class GetInstrumentResponse extends BaseResponse {
    public static GetInstrumentResponse of(String statusCode, String statusMessage, Object data) {
        GetInstrumentResponse response = new GetInstrumentResponse();
        response.setData(data);
        response.setStatusCode(statusCode);
        response.setStatusMessage(statusMessage);
        return response;
    }
}
