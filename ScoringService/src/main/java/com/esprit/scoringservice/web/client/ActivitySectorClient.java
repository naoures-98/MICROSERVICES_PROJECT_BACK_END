package com.esprit.scoringservice.web.client;

import com.esprit.scoringservice.web.dto.ActivitySector;
import com.esprit.scoringservice.web.dto.Branch;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ReferentielServiceAS",url = "${application.config.activitySector-url}")
public interface ActivitySectorClient {
    @GetMapping("/{id}")
    ActivitySector findAllScoringContractDataByActivitySector(@PathVariable("id") Long activitySectorId );

}
