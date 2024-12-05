package com.esprit.securityservice.web.service.interfaces;

import com.esprit.securityservice.web.model.Group;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IGroupService {
    ResponseEntity<List<Group>> findAll();
    ResponseEntity<Group> findById(Long id);
    ResponseEntity<Group> add(Group group);
    ResponseEntity<Group> update(Group group);
    ResponseEntity<Boolean> delete(Long id);
}
