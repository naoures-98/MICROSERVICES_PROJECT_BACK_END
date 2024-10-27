package com.esprit.scoringservice.web.service.interfaces;

import com.esprit.scoringservice.web.model.Retail;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRetailService {
    ResponseEntity<List<Retail>> findAll();
    ResponseEntity<Retail> findById(Long id);
    ResponseEntity<?> fetchRetailById(Long id);
    ResponseEntity<?> findRetailWithCurrency(Long id);
    ResponseEntity<Retail> add(Retail retail);
    ResponseEntity<Retail> update(Retail retail);
    ResponseEntity<Boolean> delete(Long id);

    ResponseEntity<?> findRetailWithAllRelations(Long id);

}
