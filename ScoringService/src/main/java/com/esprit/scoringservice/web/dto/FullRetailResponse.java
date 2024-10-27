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
public class FullRetailResponse {
    private Civility civility;
    private Gender gender;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int year;
    private String clientRequest;
    private String contractReference;
    private String email;
    private String telephone;
    private Date startDate;
    private Date endDate;
    private double capitalNominal;
    private double capitalImpaye;
    private int age;
    private long revenu;
    private int nbrDependents;
    ///
    private String employerSize;
    private ActivitySector activitySector;
    private int deptRatio ;
    private Date relationEntryDate ;
    private int seniorityRelation ;
    private Date employementEntryDate ;
    private int nbYearExperience ;
    private String unpaidPresence ;
    private String payementIncident ;
    private long  echeance ;
    ////
    private FamilySituation familySituation;
    private String profession;
    private EmployementStatus employementStatus;
    private Currency currency;
    private Branch branch;
    private FinancingType financingType;
    private ClientNotation clientNotation;
    public FullRetailResponse(
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
