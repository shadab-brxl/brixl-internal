package com.app.bxl.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.UUID;


@Data
@AllArgsConstructor
public class InitResponse extends BaseResponse {

    private Data data;

    // Constructor without data
    public InitResponse(HttpStatus httpStatus, int statusCode, String message) {
        super(httpStatus, statusCode, message);
    }

    // Constructor with data (containing the generated id)
    public InitResponse(HttpStatus httpStatus, int statusCode, String message, java.util.UUID id) {
        super(httpStatus, statusCode, message);
        InitResponse.Data embed = new Data();
        embed.setId(id);
        this.setData(embed);
    }

    @lombok.Data
    public static class Data {
        private UUID id;
    }
}