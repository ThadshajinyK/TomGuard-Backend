package com.TomGuard.Controller;

import com.TomGuard.Entity.User;
import com.TomGuard.Service.AuthenticationService;
import com.TomGuard.dto.LoginRequest;
import com.TomGuard.dto.LoginResponse;
import com.TomGuard.dto.RegisterDto;
import com.TomGuard.dto.ResetPasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("register")
    public ResponseEntity<String> createUser(@RequestBody RegisterDto registerDto){
        return authenticationService.register(registerDto);
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest);
    }



    @PostMapping("forgot-password/{email}")
    public ResponseEntity<String>forgotPassword(@PathVariable String email){
        return authenticationService.forgotPassword(email);
    }

    @PostMapping("reset-password")
    public ResponseEntity<String>resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest){
        return authenticationService.resetPassword(resetPasswordRequest);
    }

}
