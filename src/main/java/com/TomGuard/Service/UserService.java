package com.TomGuard.Service;

import com.TomGuard.Entity.User;
import com.TomGuard.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> updateUser(Long userId, User updateDto) {
        User existingUser = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("User not found !")  );

        try {
            existingUser.setFirst_name(updateDto.getFirst_name());
            existingUser.setLast_name(updateDto.getLast_name());
            existingUser.setPhone(updateDto.getPhone());
            existingUser.setLocation( updateDto.getLocation());
            existingUser.setImage(updateDto.getImage());
            existingUser.setJob_title(updateDto.getJob_title());

            User updatedUser = userRepository.save(existingUser);

            return new ResponseEntity(updatedUser, HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity("User update field !",HttpStatus.NOT_MODIFIED);
        }

    }
}
