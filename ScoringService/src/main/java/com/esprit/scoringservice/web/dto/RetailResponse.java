package com.esprit.scoringservice.web.dto;

import com.esprit.scoringservice.web.model.Civility;
import com.esprit.scoringservice.web.model.EmployementStatus;
import com.esprit.scoringservice.web.model.FamilySituation;
import com.esprit.scoringservice.web.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RetailResponse {
    private Civility civility;
    private Gender gender;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int age;
    private long revenu;
    private int nbrDependents;
    private FamilySituation familySituation;
    private String profession;
    private EmployementStatus employementStatus;
    private Currency currency;
    public RetailResponse(
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
