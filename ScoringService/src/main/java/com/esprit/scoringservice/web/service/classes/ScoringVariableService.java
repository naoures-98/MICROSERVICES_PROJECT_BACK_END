package com.esprit.scoringservice.web.service.classes;

import com.esprit.scoringservice.web.model.ScoringVariable;
import com.esprit.scoringservice.web.repository.ScoringVariableRepository;
import com.esprit.scoringservice.web.service.interfaces.IScoringVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ScoringVariableService implements IScoringVariableService {
    @Autowired
    ScoringVariableRepository scoringVariableRepository;

    public ScoringVariableService(ScoringVariableRepository scoringVariableRepository) {
        this.scoringVariableRepository = scoringVariableRepository;
    }

    @Override
    public ResponseEntity<List<ScoringVariable>> findAll() {
        try {
            return new ResponseEntity<>(scoringVariableRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ScoringVariableService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ScoringVariable> findById(Long id) {
        try {
            return new ResponseEntity(scoringVariableRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ScoringVariableService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Override
    public ResponseEntity<ScoringVariable> add(ScoringVariable scoringVariable) {
        try {
            return new ResponseEntity(scoringVariableRepository.save(scoringVariable), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ScoringVariableService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ScoringVariable> update(ScoringVariable scoringVariable) {
        try {
            return new ResponseEntity(scoringVariableRepository.save(scoringVariable), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ScoringVariableService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (scoringVariableRepository.existsById(id)) {
                scoringVariableRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ScoringVariableService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
