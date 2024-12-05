package com.esprit.securityservice.web.service.classes;

import com.esprit.securityservice.web.dto.AuthRequest;
import com.esprit.securityservice.web.dto.AuthResponse;
import com.esprit.securityservice.web.model.Group;
import com.esprit.securityservice.web.model.User;
import com.esprit.securityservice.web.repository.UserRepository;
import com.esprit.securityservice.web.service.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AuthService implements IAuthService {

    @Autowired
    UserRepository userRepository ;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;


    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getGroup().getGroupName()));
        return authorities;
    }
    @Override
    public ResponseEntity<User> saveUser(User user){
        try {
            user.setPassword(passwordEncoder.encode((user.getPassword())));
            return new ResponseEntity(userRepository.save(user), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(AuthService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public User findByUserCode(String  userCode) {
        try {
            return userRepository.findByUserCode(userCode).orElse(null);
        } catch (Exception exception) {
            Logger.getLogger(AuthService.class.getName()).log(Level.WARNING, exception.getMessage());
            return null;
        }
    }
    @Override
    public ResponseEntity<User> findById(Long id) {
        try {
            return new ResponseEntity(userRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(AuthService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<List<User>> findAll() {
        try {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(AuthService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> update(User user) {
        try {
            return new ResponseEntity(userRepository.save(user), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(AuthService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(AuthService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*public String generateToken(String username) {

        return jwtService.generateToken(username);
    }*/
    public String generateToken(String username) {
        User user = userRepository.findByUserCode(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username: " + username)
        );

        // Récupération des rôles
        Set<SimpleGrantedAuthority> roles = getAuthority(user);

        // Génération du token
        return jwtService.generateToken(username, roles);
    }

    /*public AuthResponse generateToken(AuthRequest authRequest) throws Exception{
        String userCode = authRequest.getUserCode();
        String userPassword = authRequest.getPassword();

        return jwtService.generateToken(username);
    }*/


    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}
