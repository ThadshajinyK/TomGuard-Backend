package com.TomGuard.Service;

import com.TomGuard.Entity.User;
import com.TomGuard.Repository.UserRepository;
import com.TomGuard.constants.Constants;
import com.TomGuard.dto.LoginRequest;
import com.TomGuard.dto.LoginResponse;
import com.TomGuard.dto.RegisterDto;
import com.TomGuard.dto.ResetPasswordRequest;
import com.TomGuard.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    public ResponseEntity<String> register(RegisterDto registerDto){
        try {
            boolean isEmailExists = userRepository.existsByEmail(registerDto.getEmail());
            if(isEmailExists){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exist !");
            }
            User user = new User();
            user.setEmail(registerDto.getEmail());
            user.setPassword(passwordEncoder.encode((registerDto.getPassword())));
            user.setFirst_name(registerDto.getFirst_name());
            user.setLast_name(registerDto.getLast_name());

            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registration successfully !");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed !");
        }
    }


    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {

        boolean isUserExists = userRepository.existsByEmail(loginRequest.getEmail());

        if(!isUserExists){
            return new ResponseEntity("Invalid email provided !",HttpStatus.BAD_REQUEST );
        }


        try {
            Authentication authentication =  authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            System.out.println("email => "+ authentication);
            String token = jwtUtils.generateJwtToken(authentication);
            return new ResponseEntity<>(new LoginResponse(token,userRepository.findByEmail(loginRequest.getEmail())),HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity("Incorrect password provided !",HttpStatus.BAD_REQUEST);
        }

    }



    public ResponseEntity<String> forgotPassword(String email) {
        boolean isUserExists = userRepository.existsByEmail(email);

        if(!isUserExists){
            return new ResponseEntity<>("The email you provided is incorrect !",HttpStatus.BAD_REQUEST);
        }

        try {
            User user = userRepository.findByEmail(email);
            String token = UUID.randomUUID().toString();
            user.setResetToken(token);
            userRepository.save(user);

            String url = Constants.CLINT_URL+"reset-password?token="+token;
            emailService.sendResetEmail(email,"Reset Password",url);

            return new ResponseEntity("Reset link sent your email please check your mail ",HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity("Failed to send reset link.",HttpStatus.OK);
        }
    }

    public ResponseEntity<String> resetPassword(ResetPasswordRequest resetPasswordRequest) {
        try {
            User user = userRepository.findByResetToken(resetPasswordRequest.getToken());
            user.setPassword(passwordEncoder.encode(resetPasswordRequest.getNew_password()));
            System.out.println("Password "+resetPasswordRequest.getNew_password());
            user.setResetToken(null);
            userRepository.save(user);

            return new ResponseEntity<>("Password reset Successfully !" ,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Your reset password link expired!" ,HttpStatus.BAD_REQUEST);
        }

    }
}
