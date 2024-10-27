package com.esprit.scoringservice.web.client;

import com.esprit.scoringservice.web.dto.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ReferentielService",url = "${application.config.currency-url}")
public interface CurrencyClient {
    @GetMapping("/{id}")
    Currency findAllScoringContractDataByCurrency(@PathVariable("id") Long currencyId );

}
