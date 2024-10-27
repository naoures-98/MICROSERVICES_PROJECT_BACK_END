package com.esprit.referentielservice.web.Repository;

import com.esprit.referentielservice.web.model.FinancingNature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancingNatureRepository  extends JpaRepository<FinancingNature, Long> {
}
