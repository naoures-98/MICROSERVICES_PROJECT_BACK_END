package com.esprit.scoringservice.web.controller;

import com.esprit.scoringservice.web.model.ClientNotation;
import com.esprit.scoringservice.web.service.interfaces.IClientNotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Scoring/ClientNotation")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientNotationController {
    @Autowired
    IClientNotationService clientNotationService;
    @GetMapping
    private ResponseEntity<List<ClientNotation>> findAll() {
        return clientNotationService.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<ClientNotation> findById(@PathVariable("id") Long id) {
        return clientNotationService.findById(id);
    }
    @GetMapping("/byClient/{id}")
    private ResponseEntity<ClientNotation> findClientNotationByScoringContractData_Id(@PathVariable("id") Long idClient) {
        return clientNotationService.findClientNotationByScoringContractData_Id(idClient);
    }
    @PostMapping
    private ResponseEntity<ClientNotation> add(@RequestBody ClientNotation clientNotation) {
        return clientNotationService.add(clientNotation);
    }
    @PutMapping
    private ResponseEntity<ClientNotation> update(@RequestBody ClientNotation clientNotation) {
        return clientNotationService.update(clientNotation);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return clientNotationService.delete(id);
    }
}
