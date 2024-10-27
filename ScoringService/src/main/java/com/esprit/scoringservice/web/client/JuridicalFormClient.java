package com.esprit.scoringservice.web.client;

import com.esprit.scoringservice.web.dto.Branch;
import com.esprit.scoringservice.web.dto.JuridicalForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ReferentielServiceJF",url = "${application.config.juridicalForm-url}")
public interface JuridicalFormClient {
    @GetMapping("/{id}")
    JuridicalForm findAllScoringContractDataByJuridicalForm(@PathVariable("id") Long juridicalFormId );

}
