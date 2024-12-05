package com.esprit.referentielservice.web.controller;

import com.esprit.referentielservice.web.Service.Interfaces.IJuridicalFormService;
import com.esprit.referentielservice.web.model.JuridicalForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Referentiel/JuridicalForm")
//@CrossOrigin(origins = "http://localhost:4200")
public class JuridicalFormController {
    @Autowired
    IJuridicalFormService juridicalFormService;
    @GetMapping
    private ResponseEntity<List<JuridicalForm>> findAll() {
        return juridicalFormService.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<JuridicalForm> findById(@PathVariable("id") Long id) {
        return juridicalFormService.findById(id);
    }
    @PostMapping
    private ResponseEntity<JuridicalForm> add(@RequestBody JuridicalForm juridicalForm) {
        return juridicalFormService.add(juridicalForm);
    }
    @PutMapping
    private ResponseEntity<JuridicalForm> update(@RequestBody JuridicalForm juridicalForm) {
        return juridicalFormService.update(juridicalForm);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return juridicalFormService.delete(id);
    }
}
