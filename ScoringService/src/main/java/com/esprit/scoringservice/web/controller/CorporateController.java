package com.esprit.scoringservice.web.controller;

import com.esprit.scoringservice.web.model.Corporate;
import com.esprit.scoringservice.web.service.interfaces.ICorporateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Scoring/Corporate")
//@CrossOrigin(origins = "http://localhost:4200")
public class CorporateController {
    @Autowired
    ICorporateService corporateService;
    @GetMapping
    private ResponseEntity<List<Corporate>> findAll() {
        return corporateService.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<Corporate> findById(@PathVariable("id") Long id) {
        return corporateService.findById(id);
    }
    @PostMapping
    private ResponseEntity<Corporate> add(@RequestBody Corporate corporate) {
        return corporateService.add(corporate);
    }
    @PutMapping
    private ResponseEntity<Corporate> update(@RequestBody Corporate corporate) {
        return corporateService.update(corporate);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return corporateService.delete(id);
    }

    //// getRetail with all details : branch + currency+financingType + juridicalForm + activitySector
    @GetMapping("findCorporateWithAllRelations/{id}")
    public ResponseEntity<?> findRetailWithAllRelations(@PathVariable Long id){
        return corporateService.findCorporateWithAllRelations(id);
    }
}
