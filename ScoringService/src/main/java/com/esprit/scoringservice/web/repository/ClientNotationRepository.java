package com.esprit.scoringservice.web.repository;


import com.esprit.scoringservice.web.model.ClientNotation;
import com.esprit.scoringservice.web.model.ClientSegmentConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientNotationRepository extends JpaRepository<ClientNotation, Long> {
    ClientNotation findClientNotationByScoringContractData_Id(long idClient);
}
