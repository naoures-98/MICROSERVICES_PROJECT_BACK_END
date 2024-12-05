package com.esprit.securityservice.web.service.classes;


import com.esprit.securityservice.web.model.OrganizationUser;
import com.esprit.securityservice.web.repository.OrganizationUserRepository;
import com.esprit.securityservice.web.service.interfaces.IOrganizationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class OrganizationUserService implements IOrganizationUserService {
    @Autowired
    OrganizationUserRepository organizationUserRepository;

    public OrganizationUserService(OrganizationUserRepository organizationUserRepository) {
        this.organizationUserRepository = organizationUserRepository;
    }

    @Override
    public ResponseEntity<List<OrganizationUser>> findAll() {
        try {
            return new ResponseEntity<>(organizationUserRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(OrganizationUserService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<OrganizationUser> findById(Long id) {
        try {
            return new ResponseEntity(organizationUserRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(OrganizationUserService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<OrganizationUser> add(OrganizationUser organizationUser) {
        try {
            return new ResponseEntity(organizationUserRepository.save(organizationUser), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(OrganizationUserService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<OrganizationUser> update(OrganizationUser organizationUser) {
        try {
            return new ResponseEntity(organizationUserRepository.save(organizationUser), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(OrganizationUserService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (organizationUserRepository.existsById(id)) {
                organizationUserRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(OrganizationUserService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
