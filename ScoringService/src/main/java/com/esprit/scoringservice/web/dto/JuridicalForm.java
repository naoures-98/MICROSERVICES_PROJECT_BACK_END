package com.esprit.scoringservice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JuridicalForm {
    private long id;
    private String juridicalFormCode;
    private String description;
    private Date createdAt;
    private Date updatedAt;


}