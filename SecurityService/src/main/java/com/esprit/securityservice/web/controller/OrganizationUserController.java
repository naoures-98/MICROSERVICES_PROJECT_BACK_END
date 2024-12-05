package com.esprit.securityservice.web.controller;


import com.esprit.securityservice.web.model.OrganizationUser;
import com.esprit.securityservice.web.service.interfaces.IOrganizationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Security/organizationUnit")
//@CrossOrigin(origins = "http://localhost:4200")
public class OrganizationUserController {
    @Autowired
    IOrganizationUserService organizationUserService;
    @GetMapping
    private ResponseEntity<List<OrganizationUser>> findAll() {
        return organizationUserService.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<OrganizationUser> findById(@PathVariable("id") Long id) {
        return organizationUserService.findById(id);
    }

    @PostMapping
    private ResponseEntity<OrganizationUser> add(@RequestBody OrganizationUser organizationUser) {
        return organizationUserService.add(organizationUser);
    }
    @PutMapping
    private ResponseEntity<OrganizationUser> update(@RequestBody OrganizationUser organizationUser) {
        return organizationUserService.update(organizationUser);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return organizationUserService.delete(id);
    }
}
