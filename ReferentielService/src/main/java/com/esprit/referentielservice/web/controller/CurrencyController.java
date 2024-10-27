package com.esprit.referentielservice.web.controller;

import com.esprit.referentielservice.web.Service.Interfaces.ICurrencyService;
import com.esprit.referentielservice.web.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Referentiel/Currency")
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyController {
    @Autowired
    ICurrencyService currencyService;
    @GetMapping
    private ResponseEntity<List<Currency>> findAll() {
        return currencyService.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<Currency> findById(@PathVariable("id") Long id) {
        return currencyService.findById(id);
    }
    @PostMapping
    private ResponseEntity<Currency> add(@RequestBody Currency currency) {
        return currencyService.add(currency);
    }
    @PutMapping
    private ResponseEntity<Currency> update(@RequestBody Currency currency) {
        return currencyService.update(currency);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return currencyService.delete(id);
    }

}
