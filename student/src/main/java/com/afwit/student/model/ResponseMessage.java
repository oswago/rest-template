package com.afwit.student.model;

import lombok.Data;

@Data
public class ResponseMessage {
    private Integer code;
    private String message;

    public ResponseMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
