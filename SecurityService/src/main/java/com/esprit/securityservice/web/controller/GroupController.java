package com.esprit.securityservice.web.controller;


import com.esprit.securityservice.web.model.Group;
import com.esprit.securityservice.web.service.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Security/groups")
//@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {
    @Autowired
    IGroupService groupService;
    @GetMapping
    private ResponseEntity<List<Group>> findAll() {
        return groupService.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<Group> findById(@PathVariable("id") Long id) {
        return groupService.findById(id);
    }

    @PostMapping
    private ResponseEntity<Group> add(@RequestBody Group group) {
        return groupService.add(group);
    }
    @PutMapping
    private ResponseEntity<Group> update(@RequestBody Group group) {
        return groupService.update(group);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return groupService.delete(id);
    }
}
