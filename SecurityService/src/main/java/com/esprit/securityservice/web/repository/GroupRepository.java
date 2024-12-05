package com.esprit.securityservice.web.repository;

import com.esprit.securityservice.web.model.Group;
import com.esprit.securityservice.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository <Group, Long> {
}
