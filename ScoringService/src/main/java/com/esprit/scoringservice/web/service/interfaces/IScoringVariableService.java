package com.esprit.scoringservice.web.service.interfaces;

import com.esprit.scoringservice.web.model.ScoringVariable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IScoringVariableService {
    ResponseEntity<List<ScoringVariable>> findAll();
    ResponseEntity<ScoringVariable> findById(Long id);
    ResponseEntity<ScoringVariable> add(ScoringVariable scoringVariable);
    ResponseEntity<ScoringVariable> update(ScoringVariable scoringVariable);
    ResponseEntity<Boolean> delete(Long id);
}
