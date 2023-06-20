package tomguradbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tomguradbackend.dto.LoginRequest;
import tomguradbackend.dto.LoginResponse;
import tomguradbackend.dto.RegisterDto;
import tomguradbackend.dto.ResetPasswordRequest;
import tomguradbackend.entity.User;
import tomguradbackend.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("register")
        public ResponseEntity<String> createUser(@RequestBody RegisterDto registerDto){
        return userService.register(registerDto);
        }

    @PostMapping("login")
        public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
        }

        @PutMapping("update/{userId}")
         public ResponseEntity<User> update(@PathVariable Long userId , @RequestBody User updateDto){
        return userService.updateUser(userId,updateDto);
        }

        @PostMapping("forgot-password/{email}")
         public ResponseEntity<String>forgotPassword(@PathVariable String email){
        return userService.forgotPassword(email);
        }

    @PostMapping("reset-password")
         public ResponseEntity<String>resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest){
        return userService.resetPassword(resetPasswordRequest);
    }

}
