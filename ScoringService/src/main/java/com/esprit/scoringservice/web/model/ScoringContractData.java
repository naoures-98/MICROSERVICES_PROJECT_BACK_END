package com.esprit.scoringservice.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class ScoringContractData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private int year;
    private String clientRequest;
    private String contractReference;
    private double capitalNominal;
    private double capitalImpaye;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String email;
    private String telephone;


    /////
    private double mntSollicite;
    private int duree ;
    private double mntSolliEcheance ;
    private double mntInitial;
    private double capitalRestantDu;
    private double mntEncEcheance;
    @Temporal(TemporalType.DATE)
    private Date endDateEncours;
    @Enumerated(EnumType.STRING)
    private Statut statutDossier ;
    private String retourAnalyste  ;
    /////
    @OneToOne(mappedBy = "scoringContractData")
    @JsonBackReference
    private  ClientNotation clientNotation;

    /////////////////////////////////////////////////////////////////////////////////////////////

     private long currencyId;
     private long branchId;
     private long financingTypeId;

    /////////////////////////////////////////////////////////////////////////////////////////////
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
