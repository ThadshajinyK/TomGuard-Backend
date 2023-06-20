package tomguradbackend.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tomguradbackend.repository.UserRepository;



import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        boolean isUserExists = userRepository.existsByEmail(email);

        if(!isUserExists){
            throw   new UsernameNotFoundException("Username not found");
        }
        tomguradbackend.entity.User user = userRepository.findByEmail(email);

        return new User(user.getEmail(), user.getPassword(), Collections.singletonList(mapRoleToAuthority(user.getRole())));
    }

    private GrantedAuthority mapRoleToAuthority(String role) {
        return new SimpleGrantedAuthority(role);
    }
}
