package com.esprit.scoringservice.web.dto;

import com.esprit.scoringservice.web.model.Decision;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NiveauParSegment {
    private Decision decisionOctroi;
    private Long nb;



}
