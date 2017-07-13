package com.hiczp.web.mystery.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by czp on 17-7-7.
 */
public class DataDto extends ResponseDto {
    private Map<String, Object> data = new HashMap<>();

    public DataDto() {
        super();
    }

    public DataDto(Map<String, Object> data) {
        this.data = data;
    }

    public DataDto(int code, Map<String, Object> data) {
        setCode(code);
        this.data = data;
    }

    public DataDto(String message, Map<String, Object> data) {
        setMessage(message);
        this.data = data;
    }

    public DataDto(int code, String message) {
        super(code, message);
    }

    public DataDto(int code, String message, Map<String, Object> data) {
        setCode(code);
        setMessage(message);
        this.data = data;
    }

    public DataDto put(String key, Object value) {
        data.put(key, value);
        return this;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
