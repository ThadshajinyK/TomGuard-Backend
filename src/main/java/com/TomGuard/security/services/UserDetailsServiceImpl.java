package com.TomGuard.security.services;


import com.TomGuard.Entity.User;
import com.TomGuard.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    boolean isUserExists = userRepository.existsByEmail(username);
    if(!isUserExists){
      throw   new UsernameNotFoundException("Username not found");
    }
    User user = userRepository.findByEmail(username);


    return UserDetailsImpl.build(user);
  }

}
