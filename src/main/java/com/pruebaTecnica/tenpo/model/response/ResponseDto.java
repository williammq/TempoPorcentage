package com.pruebaTecnica.tenpo.model.response;

import lombok.Data;

@Data
public class ResponseDto {
    private int code;
    private String message;
    private Object data;
}
