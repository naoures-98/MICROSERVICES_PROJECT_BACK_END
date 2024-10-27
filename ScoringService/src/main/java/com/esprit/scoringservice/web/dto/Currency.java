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
public class Currency {
    private long id;
    private String name;
    private String internalCode;
    private Date createdAt;
    private Date updatedAt;


}
