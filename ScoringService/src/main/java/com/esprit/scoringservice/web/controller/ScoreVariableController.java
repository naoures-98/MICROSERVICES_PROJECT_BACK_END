package com.esprit.scoringservice.web.controller;

import com.esprit.scoringservice.web.model.ScoreVariable;
import com.esprit.scoringservice.web.service.interfaces.IScoreVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Scoring/ScoreVariable")
public class ScoreVariableController {
    @Autowired
    IScoreVariableService scoreVariableService;
    @GetMapping
    private ResponseEntity<List<ScoreVariable>> findAll() {
        return scoreVariableService.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<ScoreVariable> findById(@PathVariable("id") Long id) {
        return scoreVariableService.findById(id);
    }

    @PostMapping
    private ResponseEntity<ScoreVariable> add(@RequestBody ScoreVariable scoreVariable) {
        return scoreVariableService.add(scoreVariable);
    }
    @PutMapping
    private ResponseEntity<ScoreVariable> update(@RequestBody ScoreVariable scoreVariable) {
        return scoreVariableService.update(scoreVariable);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return scoreVariableService.delete(id);
    }
}
