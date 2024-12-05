package com.esprit.scoringservice.web.service.interfaces;

import com.esprit.scoringservice.web.model.ScoreVariable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IScoreVariableService {
    ResponseEntity<List<ScoreVariable>> findAll();
    ResponseEntity<ScoreVariable> findById(Long id);
    ResponseEntity<ScoreVariable> add(ScoreVariable scoreVariable);
    ResponseEntity<ScoreVariable> update(ScoreVariable scoreVariable);
    ResponseEntity<Boolean> delete(Long id);
}
