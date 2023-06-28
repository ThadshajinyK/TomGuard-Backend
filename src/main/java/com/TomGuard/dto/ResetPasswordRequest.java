package com.TomGuard.dto;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String token;
    private String new_password;
}
