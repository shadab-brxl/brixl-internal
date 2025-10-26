package com.app.bxl.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class BaseResponse {
    private HttpStatus httpStatus;
    private int statusCode;
    private String message;

    public BaseResponse(HttpStatus httpStatus, int statusCode, String message) {
        this.httpStatus = httpStatus;
        this.statusCode = statusCode;
        this.message = message;
    }
}