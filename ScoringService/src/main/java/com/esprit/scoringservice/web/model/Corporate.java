package com.esprit.scoringservice.web.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Corporate extends ScoringContractData{
    private String raisonSocial;
    @Enumerated(EnumType.STRING)
    private ClientCategory clientCategory;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    ////////////////////////////////////////////////////////
    private int nbYearExercice ;
    @Temporal(TemporalType.DATE)
    private Date relationEntryDate ;
    private int seniorityRelation ;
    private String fiablityFinancialStatus ;
    private String evolutionMarche ;
    private String positionnementCommerce;
    private String comportementClient;
    private String payementIncident ;
    private String unpaidPresence ;
    private String engagementStatus;
    private int financialRentability ;
    private long fondRoulement;
    private int tauxFondRoulement;
    private int autonomieFinanciere;
    private int liquiditeGenerale;
    ////////////////////////////////////////////////////////
    private String creationPlace;
    private String numNis;
    private String numRegistreCommerce;

    /////////////////////////////////////////////////////////////////////////////////////////////
    private long juridicalFormId;
    private long activitySectorId;
    /////////////////////////////////////////////////////////////////////////////////////////////

}
