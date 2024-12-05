package com.esprit.scoringservice.web.repository;


import com.esprit.scoringservice.web.dto.ClientScore;
import com.esprit.scoringservice.web.dto.ClientScoreParDate;
import com.esprit.scoringservice.web.dto.NiveauParSegment;
import com.esprit.scoringservice.web.model.ClientNotation;
import com.esprit.scoringservice.web.model.ClientSegmentConfig;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientNotationRepository extends JpaRepository<ClientNotation, Long> {
    ClientNotation findClientNotationByScoringContractData_Id(long idClient);

    List<ClientNotation> findTop10ByOrderByNotationDateDesc();
    List<ClientNotation> findClientNotationByClientSegmentConfig_SegmentCodeOrderByNotationDateDesc(String codeSegment);

    @Query("SELECT new com.esprit.scoringservice.web.dto.ClientScore(csc.segmentCode, COUNT(cn)) " +
            "FROM ClientNotation cn " +
            "INNER JOIN cn.clientSegmentConfig csc " +
            "GROUP BY csc.segmentCode")
    List<ClientScore> calculNbrPersonneScorParSegment();

    @Query("SELECT new com.esprit.scoringservice.web.dto.NiveauParSegment(cn.decisionOctroi, COUNT(cn)) " +
            "FROM ClientNotation cn " +
            "INNER JOIN cn.clientSegmentConfig csc " +
            "where  csc.segmentCode = ?1 " +
            "GROUP BY cn.decisionOctroi")
    List<NiveauParSegment> calculNbNiveauParSegment(String segment);

    @Query("SELECT new com.esprit.scoringservice.web.dto.ClientScoreParDate(cn.notationDate, COUNT(cn)) " +
            "FROM ClientNotation cn " +
            "INNER JOIN cn.clientSegmentConfig csc " +
            "where  csc.segmentCode = ?1 " +
            "GROUP BY cn.notationDate")
    List<ClientScoreParDate> calculNbClientScoreParDate(String segment);
    @Query("SELECT new com.esprit.scoringservice.web.dto.ClientScoreParDate(cn.notationDate, COUNT(cn)) " +
            "FROM ClientNotation cn " +
            "INNER JOIN cn.clientSegmentConfig csc " +
            "GROUP BY cn.notationDate")
    List<ClientScoreParDate> calculNbClientScoreParAgence();

    @Query("SELECT new com.esprit.scoringservice.web.dto.ClientScoreParDate(cn.notationDate, COUNT(cn)) " +
            "FROM ClientNotation cn " +
            "INNER JOIN cn.clientSegmentConfig csc " +
            "GROUP BY cn.notationDate")
    List<ClientScoreParDate> detailsClientsScores();
}
