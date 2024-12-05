package com.esprit.securityservice.web.service.interfaces;

import com.esprit.securityservice.web.model.Group;
import com.esprit.securityservice.web.model.User;
import com.esprit.securityservice.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IAuthService {
    ResponseEntity<User> saveUser(User user);
    ResponseEntity<User> findById(Long id);
    User findByUserCode(String userCode);
    ResponseEntity<List<User>> findAll();
    ResponseEntity<User> update(User user);
    ResponseEntity<Boolean> delete(Long id);
}
