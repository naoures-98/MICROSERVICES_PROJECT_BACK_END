package com.esprit.scoringservice.web.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class ClientNotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    private Date notationDate;
    private int finalScore;
    private int adjustedScore;
    private double pd;
    private double scoreProbabiliste;
    @Enumerated(EnumType.STRING)
    private Decision decisionOctroi;
    @Enumerated(EnumType.STRING)
    private Classe classe;


    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    @OneToOne
    @JsonManagedReference
    private ScoringContractData scoringContractData;


    /*@ManyToOne
    @JsonManagedReference
    private ClientSegmentConfig clientSegmentConfig;*/

    @ManyToOne
    //@JsonManagedReference
    private ClientSegmentConfig clientSegmentConfig;
}
