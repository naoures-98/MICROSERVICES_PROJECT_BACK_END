package com.esprit.scoringservice.web.service.interfaces;

import com.esprit.scoringservice.web.dto.ClientScore;
import com.esprit.scoringservice.web.dto.ClientScoreParDate;
import com.esprit.scoringservice.web.dto.NiveauParSegment;
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

    ResponseEntity<List <ClientScore>> calculNbrPersonneScorParSegment();
    ResponseEntity <List <NiveauParSegment>> calculNbNiveauParSegment(String segment);
    ResponseEntity <List <ClientScoreParDate>> calculNbClientScoreParDate(String segment);

    ResponseEntity<List<ClientNotation>> findTop10ByOrderByNotationDateDesc();
    ResponseEntity<List<ClientNotation>> findClientNotationByClientSegmentConfig_SegmentCodeOrderByNotationDateDesc(String segment);
}
