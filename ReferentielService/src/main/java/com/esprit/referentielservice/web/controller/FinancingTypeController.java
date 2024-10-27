package com.esprit.referentielservice.web.controller;

import com.esprit.referentielservice.web.Service.Interfaces.IFinancingTypeService;
import com.esprit.referentielservice.web.model.FinancingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Referentiel/FinancingType")
@CrossOrigin(origins = "http://localhost:4200")
public class FinancingTypeController {
    @Autowired
    IFinancingTypeService financingTypeService;
    @GetMapping
    private ResponseEntity<List<FinancingType>> findAll() {
        return financingTypeService.findAll();
    }

    @GetMapping("/financingNature/{financingNature}")
    private ResponseEntity<List<FinancingType>> findFinancingTypeByFinancingNature_ProjectNature(@PathVariable("financingNature") String financingNature) {
        return financingTypeService.findFinancingTypeByFinancingNature_ProjectNature(financingNature);
    }

    @GetMapping("/{id}")
    private ResponseEntity<FinancingType> findById(@PathVariable("id") Long id) {
        return financingTypeService.findById(id);
    }
    @GetMapping("/code/{typeCode}")
    private ResponseEntity<FinancingType> findByFinancingTypeCode(@PathVariable("typeCode") String typeCode) {
        return financingTypeService.findByFinancingTypeCode(typeCode);
    }
    @PostMapping
    private ResponseEntity<FinancingType> add(@RequestBody FinancingType financingType) {
        System.out.println(" ******* financingType = " + financingType.toString());
        System.out.println(" ******* financingNature = " + financingType.getFinancingNature());
        return financingTypeService.add(financingType);
    }
    @PutMapping
    private ResponseEntity<FinancingType> update(@RequestBody FinancingType financingType) {
        return financingTypeService.update(financingType);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return financingTypeService.delete(id);
    }

}
