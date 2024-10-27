package com.esprit.referentielservice.web.Service.Interfaces;

import com.esprit.referentielservice.web.model.FinancingNature;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFinancingNatureService {
    ResponseEntity<List<FinancingNature>> findAll();
    ResponseEntity<FinancingNature> findById(Long id);
    ResponseEntity<FinancingNature> add(FinancingNature financingNature);
    ResponseEntity<FinancingNature> update(FinancingNature financingNature);
    ResponseEntity<Boolean> delete(Long id);
}
