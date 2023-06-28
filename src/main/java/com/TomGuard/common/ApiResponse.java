package com.TomGuard.common;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private int statusCode;
    private String message;
    private T data;
}
