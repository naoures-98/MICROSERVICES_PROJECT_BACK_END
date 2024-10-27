package com.esprit.referentielservice.web.Service.Interfaces;

import com.esprit.referentielservice.web.model.JuridicalForm;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IJuridicalFormService {
    ResponseEntity<List<JuridicalForm>> findAll();
    ResponseEntity<JuridicalForm> findById(Long id);
    ResponseEntity<JuridicalForm> add(JuridicalForm juridicalForm);
    ResponseEntity<JuridicalForm> update(JuridicalForm juridicalForm);
    ResponseEntity<Boolean> delete(Long id);
}
