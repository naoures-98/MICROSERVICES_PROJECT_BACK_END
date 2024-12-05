package com.esprit.referentielservice.web.controller;

import com.esprit.referentielservice.web.Service.Interfaces.IFinancingNatureService;
import com.esprit.referentielservice.web.model.FinancingNature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Referentiel/FinancingNature")
//@CrossOrigin(origins = "http://localhost:4200")
public class FinancingNatureController {
    @Autowired
    IFinancingNatureService financingNatureService;
    @GetMapping
    private ResponseEntity<List<FinancingNature>> findAll() {
        return financingNatureService.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<FinancingNature> findById(@PathVariable("id") Long id) {
        return financingNatureService.findById(id);
    }
    @PostMapping
    private ResponseEntity<FinancingNature> add(@RequestBody FinancingNature financingNature) {
        return financingNatureService.add(financingNature);
    }
    @PutMapping
    private ResponseEntity<FinancingNature> update(@RequestBody FinancingNature financingNature) {
        return financingNatureService.update(financingNature);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return financingNatureService.delete(id);
    }

}
