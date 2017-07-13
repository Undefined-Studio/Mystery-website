package com.hiczp.web.mystery.dto;

import java.sql.Timestamp;

/**
 * Created by czp on 17-7-7.
 */
public class ResponseDto {
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private int code = 0;

    private String message = "";

    public ResponseDto() {

    }

    public ResponseDto(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
