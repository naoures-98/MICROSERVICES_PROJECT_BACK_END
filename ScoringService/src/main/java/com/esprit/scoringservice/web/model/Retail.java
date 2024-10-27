package com.esprit.scoringservice.web.model;

import com.esprit.scoringservice.web.dto.ActivitySector;
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
public class Retail extends ScoringContractData{
    @Enumerated(EnumType.STRING)
    private Civility civility;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private int age;
    private long revenu;
    private int nbrDependents;
    //////
    private String employerSize; // taille employeur

    private long activitySectorId;

    private int deptRatio ;
    @Temporal(TemporalType.DATE)
    private Date relationEntryDate ;
    private int seniorityRelation ;

    @Temporal(TemporalType.DATE)
    private Date employementEntryDate ;
    private int nbYearExperience ;


    private String unpaidPresence ;
    private String payementIncident ;
    private long echeance;
    ///////////

    @Enumerated(EnumType.STRING)
    private FamilySituation familySituation;
    private String profession;
    @Enumerated(EnumType.STRING)
    private EmployementStatus employementStatus;

    /*public Retail(long id,  Civility civility, Gender gender, String firstName, String lastName,FamilySituation familySituation, String profession, EmployementStatus employementStatus) {
        //super(id, year, clientRequest, contractReference, capitalNominal, capitalImpaye, startDate, endDate, email, telephone, clientNotation, currencyId, branchId, financingTypeId, createdAt, updatedAt);
        this.civility = civility;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.familySituation = familySituation;
        this.profession = profession;
        this.employementStatus = employementStatus;
    }*/
}
