package com.esprit.securityservice.web.config;

import com.esprit.securityservice.web.model.Group;
import com.esprit.securityservice.web.model.User;
import com.esprit.securityservice.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsersDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository ;
    @Override
    public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException {
        Optional<User> user =  userRepository.findByUserCode(userCode);

        return user.map(com.esprit.securityservice.web.config.UserDetails :: new)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with  name : "+userCode+"!!"));
    }
}
