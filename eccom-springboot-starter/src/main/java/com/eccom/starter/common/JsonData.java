package com.eccom.starter.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonData {

    private Integer code;
    private String msg;
    private Object data;

    public static JsonData ok() {
        return new JsonData(200, "ok", null);
    }

    public static JsonData ok(String msg) {
        return new JsonData(200, msg, null);
    }

    public static JsonData ok(Object data) {
        return new JsonData(200, "ok", data);
    }

    public static JsonData ok(String msg, Object data) {
        return new JsonData(200, msg, data);
    }


    public static JsonData error() {
        return new JsonData(500, "error", null);
    }

    public static JsonData error(int code) {
        return new JsonData(code, "error", null);
    }

    public static JsonData error(String msg) {
        return new JsonData(500, msg, null);
    }

    public static JsonData error(int code, String msg) {
        return new JsonData(code, msg, null);
    }

}
