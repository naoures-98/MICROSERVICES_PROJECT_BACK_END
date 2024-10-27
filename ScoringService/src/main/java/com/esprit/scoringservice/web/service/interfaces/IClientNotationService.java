package com.esprit.scoringservice.web.service.interfaces;

import com.esprit.scoringservice.web.model.ClientNotation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClientNotationService {
    ResponseEntity<List<ClientNotation>> findAll();
    ResponseEntity<ClientNotation> findById(Long id);
    ResponseEntity<ClientNotation> add(ClientNotation clientNotation);
    ResponseEntity<ClientNotation> update(ClientNotation clientNotation);
    ResponseEntity<Boolean> delete(Long id);
    ResponseEntity<ClientNotation> findClientNotationByScoringContractData_Id(Long idClient);

}
