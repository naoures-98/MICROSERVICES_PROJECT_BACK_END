package com.esprit.securityservice.web.service.classes;


import com.esprit.securityservice.web.model.Group;
import com.esprit.securityservice.web.repository.GroupRepository;
import com.esprit.securityservice.web.service.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class GroupService implements IGroupService {
    @Autowired
    GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public ResponseEntity<List<Group>> findAll() {
        try {
            return new ResponseEntity<>(groupRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(GroupService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Group> findById(Long id) {
        try {
            return new ResponseEntity(groupRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(GroupService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<Group> add(Group group) {
        try {
            return new ResponseEntity(groupRepository.save(group), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(GroupService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Group> update(Group group) {
        try {
            return new ResponseEntity(groupRepository.save(group), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(GroupService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (groupRepository.existsById(id)) {
                groupRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(GroupService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
