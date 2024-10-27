package com.esprit.referentielservice.web.Service.classes;

import com.esprit.referentielservice.web.Repository.JuridicalFormRepository;
import com.esprit.referentielservice.web.Service.Interfaces.IJuridicalFormService;
import com.esprit.referentielservice.web.model.JuridicalForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class JuridicalFormService implements IJuridicalFormService {
    @Autowired
    JuridicalFormRepository juridicalFormRepository;

    public JuridicalFormService(JuridicalFormRepository juridicalFormRepository) {
        this.juridicalFormRepository = juridicalFormRepository;
    }

    @Override
    public ResponseEntity<List<JuridicalForm>> findAll() {
        try {
            return new ResponseEntity<>(juridicalFormRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(JuridicalFormService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<JuridicalForm> findById(Long id) {
        try {
            return new ResponseEntity(juridicalFormRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(JuridicalFormService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<JuridicalForm> add(JuridicalForm juridicalForm) {
        try {
            return new ResponseEntity(juridicalFormRepository.save(juridicalForm), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(JuridicalFormService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<JuridicalForm> update(JuridicalForm juridicalForm) {
        try {
            return new ResponseEntity(juridicalFormRepository.save(juridicalForm), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(JuridicalFormService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (juridicalFormRepository.existsById(id)) {
                juridicalFormRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(JuridicalFormService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
