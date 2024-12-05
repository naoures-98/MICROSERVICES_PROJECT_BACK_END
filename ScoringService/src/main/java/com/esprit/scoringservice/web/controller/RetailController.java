package com.esprit.scoringservice.web.controller;

import com.esprit.scoringservice.web.model.Retail;
import com.esprit.scoringservice.web.service.interfaces.IRetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Scoring/Retail")
//@CrossOrigin(origins = "http://localhost:4200")
public class RetailController {
    @Autowired
    IRetailService retailService;
    @GetMapping
    private ResponseEntity<List<Retail>> findAll() {
        return retailService.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<Retail> findById(@PathVariable("id") Long id) {
        return retailService.findById(id);
    }
    @PostMapping
    private ResponseEntity<Retail> add(@RequestBody Retail retail) {
        return retailService.add(retail);
    }
    @PutMapping
    private ResponseEntity<Retail> update(@RequestBody Retail retail) {
        return retailService.update(retail);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return retailService.delete(id);
    }

    @GetMapping("fetch/{id}")
    public ResponseEntity<?> fetchRetailById(@PathVariable Long id){
        return retailService.fetchRetailById(id);
    }

    @GetMapping("findRetailWithCurrency/{id}")
    public ResponseEntity<?> findRetailWithCurrency(@PathVariable Long id){
        return retailService.findRetailWithCurrency(id);
    }

    //// getRetail with all details : branch + currency+financingType
    @GetMapping("findRetailWithAllRelations/{id}")
    public ResponseEntity<?> findRetailWithAllRelations(@PathVariable Long id){
        return retailService.findRetailWithAllRelations(id);
    }
}
