package com.esprit.scoringservice.web.controller;

import com.esprit.scoringservice.web.model.ClientSegmentConfig;
import com.esprit.scoringservice.web.service.interfaces.IClientSegmentConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Scoring/CSC")
//@CrossOrigin(origins = "http://localhost:4200")
public class ClientSegmentConfigController {
    @Autowired
    IClientSegmentConfigService clientSegmentConfigService;
    @GetMapping
    private ResponseEntity<List<ClientSegmentConfig>> findAll() {
        return clientSegmentConfigService.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<ClientSegmentConfig> findById(@PathVariable("id") Long id) {
        return clientSegmentConfigService.findById(id);
    }
    @GetMapping("/code/{code}")
    private ResponseEntity<ClientSegmentConfig> findClientSegmentConfigBySegmentCode(@PathVariable("code") String code) {
        return clientSegmentConfigService.findClientSegmentConfigBySegmentCode(code);
    }
    @PostMapping
    private ResponseEntity<ClientSegmentConfig> add(@RequestBody ClientSegmentConfig clientSegmentConfig) {
        return clientSegmentConfigService.add(clientSegmentConfig);
    }
    @PutMapping
    private ResponseEntity<ClientSegmentConfig> update(@RequestBody ClientSegmentConfig clientSegmentConfig) {
        return clientSegmentConfigService.update(clientSegmentConfig);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return clientSegmentConfigService.delete(id);
    }
}
