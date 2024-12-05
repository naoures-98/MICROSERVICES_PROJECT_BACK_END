package com.esprit.securityservice.web.repository;

import com.esprit.securityservice.web.model.OrganizationUser;
import com.esprit.securityservice.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationUserRepository extends JpaRepository <OrganizationUser, Long> {
}
