package com.TomGuard.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private Object data;

    public LoginResponse(String token,Object data){
        this.token = token;
        this.data=data;
    }
}
