package com.esprit.scoringservice.web.service.classes;

import com.esprit.scoringservice.web.model.ScoreVariable;
import com.esprit.scoringservice.web.repository.ScoreVariableRepository;
import com.esprit.scoringservice.web.service.interfaces.IScoreVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ScoreVariableService implements IScoreVariableService {
    @Autowired
    ScoreVariableRepository scoreVariableRepository;

    public ScoreVariableService(ScoreVariableRepository scoreVariableRepository) {
        this.scoreVariableRepository = scoreVariableRepository;
    }

    @Override
    public ResponseEntity<List<ScoreVariable>> findAll() {
        try {
            return new ResponseEntity<>(scoreVariableRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ScoreVariableService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ScoreVariable> findById(Long id) {
        try {
            return new ResponseEntity(scoreVariableRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ScoreVariableService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Override
    public ResponseEntity<ScoreVariable> add(ScoreVariable scoreVariable) {
        try {
            return new ResponseEntity(scoreVariableRepository.save(scoreVariable), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ScoreVariableService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ScoreVariable> update(ScoreVariable scoreVariable) {
        try {
            return new ResponseEntity(scoreVariableRepository.save(scoreVariable), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ScoreVariableService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (scoreVariableRepository.existsById(id)) {
                scoreVariableRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ScoreVariableService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
