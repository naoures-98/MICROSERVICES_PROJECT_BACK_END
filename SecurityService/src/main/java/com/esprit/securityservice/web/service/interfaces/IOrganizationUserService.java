package com.esprit.securityservice.web.service.interfaces;

import com.esprit.securityservice.web.model.Group;
import com.esprit.securityservice.web.model.OrganizationUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrganizationUserService {
    ResponseEntity<List<OrganizationUser>> findAll();
    ResponseEntity<OrganizationUser> findById(Long id);
    ResponseEntity<OrganizationUser> add(OrganizationUser organizationUser);
    ResponseEntity<OrganizationUser> update(OrganizationUser organizationUser);
    ResponseEntity<Boolean> delete(Long id);
}
