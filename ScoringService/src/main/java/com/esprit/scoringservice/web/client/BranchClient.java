package com.esprit.scoringservice.web.client;

import com.esprit.scoringservice.web.dto.Branch;
import com.esprit.scoringservice.web.dto.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ReferentielServiceB",url = "${application.config.branch-url}")
public interface BranchClient {
    @GetMapping("/{id}")
    Branch findAllScoringContractDataByBranch(@PathVariable("id") Long branchId );

}
