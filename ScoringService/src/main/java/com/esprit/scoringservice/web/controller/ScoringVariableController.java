package com.esprit.scoringservice.web.controller;

import com.esprit.scoringservice.web.model.ScoringVariable;
import com.esprit.scoringservice.web.service.interfaces.IScoringVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Scoring/ScoringVariable")
public class ScoringVariableController {
    @Autowired
    IScoringVariableService scoringVariableService;
    @GetMapping
    private ResponseEntity<List<ScoringVariable>> findAll() {
        return scoringVariableService.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<ScoringVariable> findById(@PathVariable("id") Long id) {
        return scoringVariableService.findById(id);
    }

    @PostMapping
    private ResponseEntity<ScoringVariable> add(@RequestBody ScoringVariable scoringVariable) {
        return scoringVariableService.add(scoringVariable);
    }
    @PutMapping
    private ResponseEntity<ScoringVariable> update(@RequestBody ScoringVariable scoringVariable) {
        return scoringVariableService.update(scoringVariable);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return scoringVariableService.delete(id);
    }
}
