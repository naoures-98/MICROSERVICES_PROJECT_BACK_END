package com.esprit.scoringservice.web.dto;

import com.esprit.scoringservice.web.model.*;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FullCorporateResponse {
    private String raisonSocial;
    private ClientCategory clientCategory;
    private Date creationDate;
    private String creationPlace;
    private String numNis;
    private String numRegistreCommerce;
    /////////////////////
    private int nbYearExercice ;
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
    ////////////////////
    private int year;
    private String clientRequest;
    private String contractReference;
    private String email;
    private String telephone;
    private Date startDate;
    private Date endDate;
    private double capitalNominal;
    private double capitalImpaye;


    private Currency currency;
    private Branch branch;
    private FinancingType financingType;
    private ActivitySector activitySector;
    private JuridicalForm juridicalForm;
    private ClientNotation clientNotation;
    public FullCorporateResponse(
        Civility civility
        , Gender gender
        , String firstName
        , String lastName
        , Date birthDate
        , int age
        , long revenu
        , int nbrDependents
        , FamilySituation familySituation
        , String profession
        , EmployementStatus employementStatus
        //, Currency currency

    ) {
    }
}
