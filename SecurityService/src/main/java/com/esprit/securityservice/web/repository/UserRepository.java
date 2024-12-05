package com.esprit.securityservice.web.repository;

import com.esprit.securityservice.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findByUserCode(String userCode);
}
