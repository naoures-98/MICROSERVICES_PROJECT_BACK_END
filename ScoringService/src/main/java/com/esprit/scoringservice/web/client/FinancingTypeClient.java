package com.esprit.scoringservice.web.client;

import com.esprit.scoringservice.web.dto.Currency;
import com.esprit.scoringservice.web.dto.FinancingType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ReferentielServiceFT",url = "${application.config.financingType-url}")
public interface FinancingTypeClient {
    @GetMapping("/{id}")
    FinancingType findAllScoringContractDataByFinancingType(@PathVariable("id") Long financingTypeId );

}
