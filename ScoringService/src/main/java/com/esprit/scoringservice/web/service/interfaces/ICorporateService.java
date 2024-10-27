package com.esprit.scoringservice.web.service.interfaces;

import com.esprit.scoringservice.web.model.Corporate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICorporateService {
    ResponseEntity<List<Corporate>> findAll();
    ResponseEntity<Corporate> findById(Long id);
    ResponseEntity<Corporate> add(Corporate corporate);
    ResponseEntity<Corporate> update(Corporate corporate);
    ResponseEntity<Boolean> delete(Long id);


    ResponseEntity<?> findCorporateWithAllRelations(Long id);
}
