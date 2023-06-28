package com.TomGuard.Controller;

import com.TomGuard.Entity.User;
import com.TomGuard.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/{userId}")
    public ResponseEntity<User> update(@PathVariable Long userId , @RequestBody User updateDto){
        return userService.updateUser(userId,updateDto);
    }


}
